package com.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentRecordNotFoundException extends Exception {

	public StudentRecordNotFoundException(String message) {
		// TODO Auto-generated constructor stub

		super(message);
	}
}
