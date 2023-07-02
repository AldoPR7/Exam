package com.exam.demo.tdo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data


public class ResponseDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String statusCode;
	private String message;
	private Integer receivedDateTime;
	public ResponseDetail(String statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String strFecha = sdf.format(new Date());
		Integer yyyymmdd = Integer.parseInt(strFecha); 
		
		this.receivedDateTime = yyyymmdd;
	}
	
}
