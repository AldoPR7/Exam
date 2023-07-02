package com.exam.demo.tdo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ExceptionDetail implements Serializable{
	
	/**
	 * cause of exception.
	 */
	private String cause;
	/**
	 * detail of exception.
	 */
	private String detail;

	private static final long serialVersionUID = 1L;

	public ExceptionDetail(String cause, String detail) {
		super();
		this.cause = cause;
		this.detail = detail;
	}
	
	
	
}
