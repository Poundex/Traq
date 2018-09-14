package net.poundex.traq

class DtoService
{
	Map<String, ?> toDto(Object object)
	{
		return object.properties
	}

	List<Map<String, ?>> toDtos(Iterable<?> iterable)
	{
		return iterable.collect(this.&toDto)
	}
}
