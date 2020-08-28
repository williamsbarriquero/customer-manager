package com.wwwgomes.customermanager.domain.exception;

public class EntityInUseException extends RuntimeException {

	private static final long serialVersionUID = -3424762216663057893L;

	public EntityInUseException(String msg) {
		super(msg);
	}

}
