package com.rtarcisio.todo_back.services.exceptions;

public class DataInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataInvalidaException(String msg) {
		super(msg);
	}

}
