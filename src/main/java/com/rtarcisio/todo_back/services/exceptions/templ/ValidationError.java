package com.rtarcisio.todo_back.services.exceptions.templ;


import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, String path) {
		super(status, msg, path);
	}
//
	public List<FieldMessage> getErrors() {
		return errors;
	}
//
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

}
