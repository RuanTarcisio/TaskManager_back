package com.rtarcisio.todo_back.services.exceptions;

public class UsuarioInvalidoException  extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	public UsuarioInvalidoException(String msg) {
		super(msg);
	}
	
}
