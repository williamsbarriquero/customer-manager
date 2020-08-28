package com.wwwgomes.customermanager.domain.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4184493622311156201L;

	public ObjectNotFoundException(String key, String entityType) {
		super("Object not found! ID: " + key + " Type: " + entityType);
	}

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable error) {
		super(msg, error);
	}
}
