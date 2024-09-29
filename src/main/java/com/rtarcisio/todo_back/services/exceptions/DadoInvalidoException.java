package com.rtarcisio.todo_back.services.exceptions;

public class DadoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DadoInvalidoException(String msg) {
		super(msg);
	}

}
