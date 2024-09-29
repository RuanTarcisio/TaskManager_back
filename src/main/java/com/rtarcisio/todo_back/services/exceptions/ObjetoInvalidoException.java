package com.rtarcisio.todo_back.services.exceptions;

public class ObjetoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoInvalidoException(String msg) {
		super(msg);
	}

}
