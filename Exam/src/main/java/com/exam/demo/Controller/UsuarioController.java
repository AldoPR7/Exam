package com.exam.demo.Controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.exam.demo.Service.UsuarioService;
import com.exam.demo.tdo.ExceptionDetail;
import com.exam.demo.tdo.Response;
import com.exam.demo.tdo.ResponseDetail;
import com.exam.demo.tdo.UsuarioDto;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("/usu")
	String home() {
		return"upp";	
	}

    @GetMapping("/val/usu")
	@ResponseBody
	public ResponseEntity<Response> getUsua() throws Exception {
	Response response;
	HttpStatus httpStatus;	
	try {
		response=new Response(new ResponseDetail("OK", "Success"),usuarioService.getBuscaUsuario());
		httpStatus=HttpStatus.OK;
	}catch (EntityNotFoundException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.BAD_REQUEST;
	}catch (HttpServerErrorException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}catch (Exception e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}
	return new ResponseEntity<Response>(response, httpStatus);
			
		}
    
    
    @PostMapping("/alt/usu")
	@ResponseBody
	public ResponseEntity<Response> register(@RequestBody UsuarioDto entity ) throws Exception {
	Response response;
	HttpStatus httpStatus;	
	try {
		response=new Response(new ResponseDetail("OK", "Success"),usuarioService.postAlta(entity));
		httpStatus=HttpStatus.OK;
	}catch (EntityNotFoundException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.BAD_REQUEST;
	}catch (HttpServerErrorException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}catch (Exception e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}
	return new ResponseEntity<Response>(response, httpStatus);
			
		}
    
    
    @PostMapping("/elim/usu")
	@ResponseBody
	public ResponseEntity<Response> elimina(@RequestBody UsuarioDto entity ) throws Exception {
	Response response;
	HttpStatus httpStatus;	
	System.out.println("entro");
	try {
		response=new Response(new ResponseDetail("OK", "Success"),usuarioService.postElim(entity));
		httpStatus=HttpStatus.OK;
	}catch (EntityNotFoundException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.BAD_REQUEST;
	}catch (HttpServerErrorException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}catch (Exception e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}
	return new ResponseEntity<Response>(response, httpStatus);
			
		}
    
    @PostMapping("/mod/usu")
	@ResponseBody
	public ResponseEntity<Response> modifica(@RequestBody UsuarioDto entity ) throws Exception {
	Response response;
	HttpStatus httpStatus;	
	System.out.println("entro");
	try {
		response=new Response(new ResponseDetail("OK", "Success"),usuarioService.postMod(entity));
		httpStatus=HttpStatus.OK;
	}catch (EntityNotFoundException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.BAD_REQUEST;
	}catch (HttpServerErrorException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}catch (Exception e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}
	return new ResponseEntity<Response>(response, httpStatus);
			
		}
   
    @PostMapping("/usu/ver")
 	@ResponseBody
 	public ResponseEntity<Response> usuarioVal(@RequestBody UsuarioDto entity ) throws Exception {
 	Response response;
 	HttpStatus httpStatus;	
 	System.out.println("entro");
 	try {
 		response=new Response(new ResponseDetail("OK", "Success"),usuarioService.usuEx(entity));
 		httpStatus=HttpStatus.OK;
 	}catch (EntityNotFoundException e) {
 		
 		response = new Response(new ExceptionDetail("Error", e.getMessage()));
 		httpStatus=HttpStatus.BAD_REQUEST;
 	}catch (HttpServerErrorException e) {
 		
 		response = new Response(new ExceptionDetail("Error", e.getMessage()));
 		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
 	}catch (Exception e) {
 		
 		response = new Response(new ExceptionDetail("Error", e.getMessage()));
 		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
 	}
 	return new ResponseEntity<Response>(response, httpStatus);
 			
 		}
    
    
    @GetMapping("/val/sta/{status}")
	@ResponseBody
	public ResponseEntity<Response> getSta(@PathVariable String status) throws Exception {
	Response response;
	HttpStatus httpStatus;	
	try {
		response=new Response(new ResponseDetail("OK", "Success"),usuarioService.getStatus(status));
		httpStatus=HttpStatus.OK;
	}catch (EntityNotFoundException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.BAD_REQUEST;
	}catch (HttpServerErrorException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}catch (Exception e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}
	return new ResponseEntity<Response>(response, httpStatus);
			
		}
    
    
    @GetMapping("/val/nom/{nombre}")
	@ResponseBody
	public ResponseEntity<Response> getNom(@PathVariable String nombre) throws Exception {
	Response response;
	HttpStatus httpStatus;	
	try {
		response=new Response(new ResponseDetail("OK", "Success"),usuarioService.usuarioNom(nombre));
		httpStatus=HttpStatus.OK;
	}catch (EntityNotFoundException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.BAD_REQUEST;
	}catch (HttpServerErrorException e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}catch (Exception e) {
		
		response = new Response(new ExceptionDetail("Error", e.getMessage()));
		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
	}
	return new ResponseEntity<Response>(response, httpStatus);
			
		}
    
    
    @PostMapping("/usu/fech")
 	@ResponseBody
 	public ResponseEntity<Response> usuarioFech(@RequestBody UsuarioDto entity ) throws Exception {
 	Response response;
 	HttpStatus httpStatus;	
 	System.out.println("entro");
 	try {
 		response=new Response(new ResponseDetail("OK", "Success"),usuarioService.usuarioFech(entity));
 		httpStatus=HttpStatus.OK;
 	}catch (EntityNotFoundException e) {
 		
 		response = new Response(new ExceptionDetail("Error", e.getMessage()));
 		httpStatus=HttpStatus.BAD_REQUEST;
 	}catch (HttpServerErrorException e) {
 		
 		response = new Response(new ExceptionDetail("Error", e.getMessage()));
 		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
 	}catch (Exception e) {
 		
 		response = new Response(new ExceptionDetail("Error", e.getMessage()));
 		httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
 	}
 	return new ResponseEntity<Response>(response, httpStatus);
 			
 		}
    

}
