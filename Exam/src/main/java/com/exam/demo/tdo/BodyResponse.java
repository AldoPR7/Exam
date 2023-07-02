package com.exam.demo.tdo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data


public class BodyResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object obj;
	
	public BodyResponse(Object obj) {
		super();
		this.obj = obj;
	}

}
