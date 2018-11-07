package net.poundex.traq.server.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException
{
	public NotFoundException(Class<?> klass, Serializable id) {
		super("Object of type ${klass.simpleName} with id ${id} not found");
	}
}
