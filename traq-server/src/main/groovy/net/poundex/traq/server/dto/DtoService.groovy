package net.poundex.traq.server.dto

import groovy.transform.CompileStatic
import org.springframework.beans.BeanUtils
import org.springframework.beans.GenericTypeAwarePropertyDescriptor
import org.springframework.stereotype.Service

import java.beans.ParameterDescriptor
import java.beans.PropertyDescriptor

@Service
@CompileStatic
class DtoService
{
	public <T extends Dto> T toDto(Object object, Class<T> target)
	{
		Map<String, PropertyDescriptor> srcProps = mapProperties(object.class)
		Map<String, PropertyDescriptor> targetProps = mapProperties(target)
		T val = target.newInstance()
		targetProps
				.findAll { n, pd -> srcProps.containsKey(n) }
				.findAll { n, pd -> srcProps[n].readMethod && pd.writeMethod }
				.each { n, pd -> writeProperty(object, srcProps[n], val, pd) }
		return val
	}

	public <T extends Dto> Iterable<T> toDtos(Collection<?> source, Class<T> target)
	{
		return toDtos(source, target, [:])
	}

	public  <T extends Dto> Iterable<T> toDtos(Collection<?> source, Class<T> target, Map<Class<?>, Class<T>> typeMap)
	{
		return source.collect { Object it -> toDto(it, typeMap[it.getClass()] ?: target) }
	}

	private Map<String, PropertyDescriptor> mapProperties(Class<?> klass)
	{
		PropertyDescriptor[] props = BeanUtils.getPropertyDescriptors(klass)
		return props.collectEntries {
			[it.name, it]
		}
	}

	private void writeProperty(Object source, PropertyDescriptor sourceProp, Dto target, PropertyDescriptor targetProp)
	{
		if(Dto.isAssignableFrom(targetProp.propertyType))
			targetProp.writeMethod.invoke(target, toDto(sourceProp.readMethod.invoke(source), targetProp.propertyType as Class<Dto>))
//		else if(Collection.isAssignableFrom(targetProp.propertyType))
//			targetProp.writeMethod.invoke(target, ((Iterable)sourceProp.readMethod.invoke(source)).collect { toDto(it, ) }
		else
			targetProp.writeMethod.invoke(target, sourceProp.readMethod.invoke(source))
	}
}
