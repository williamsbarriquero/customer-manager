package com.wwwgomes.customermanager.domain.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3587321507424076529L;

	public EntityNotFoundException(String msg) {
		super(msg);
	}

}
