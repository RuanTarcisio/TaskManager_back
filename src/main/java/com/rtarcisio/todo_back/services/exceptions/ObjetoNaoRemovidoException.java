package com.rtarcisio.todo_back.services.exceptions;

public class ObjetoNaoRemovidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoRemovidoException(String msg) {
		super(msg);
	}

}
