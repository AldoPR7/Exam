package com.exam.demo.tdo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * serialVersionUID.
	 */

	/**
	 * responseDetail.
	 */
	private ResponseDetail responseDetail;
	/**
	 * bodyResponse.
	 */
	private Object bodyResponse;
	/**
	 * exceptionDetail.
	 */
	private ExceptionDetail exceptionDetail;
	public Response(ResponseDetail responseDetail, Object bodyResponse) {
		super();
		this.responseDetail = responseDetail;
		this.bodyResponse = bodyResponse;
	}
	public Response(ExceptionDetail exceptionDetail) {
		super();
		this.exceptionDetail = exceptionDetail;
	}
	public Response(ResponseDetail responseDetail, Object bodyResponse, ExceptionDetail exceptionDetail) {
		super();
		this.responseDetail = responseDetail;
		this.bodyResponse = bodyResponse;
		this.exceptionDetail = exceptionDetail;
	}
	
	

	
	

}
