package com.exam.demo.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.demo.Repository.UsuarioRepository;
import com.exam.demo.Service.UsuarioService;
import com.exam.demo.entity.Usuario;
import com.exam.demo.tdo.UsuarioDto;
import com.exam.demo.utils.Encripta;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	 
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	
	
	
	@Override
	public List<Usuario> getBuscaUsuario() {
		
		System.out.println("usuarios"+usuarioRepository.findAll());
		usuarioRepository.findAll();
		//usuarioRepository.insertAutoTeOseda(null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, null);
		return usuarioRepository.findAll();
		
		
	}
	
	public Map<String, Object> postAlta(UsuarioDto entity) {
		 System.out.println("validacion"+ entity.toString());
			   usuarioRepository.insertUsuario(entity.getLogin(),	   
			   Encripta.getEncriptar(entity.getPassword()),
			   entity.getNombre(), entity.getCliente(), 
			   entity.getEmail(), entity.getStatus(), entity.getIntentos(), 
			   entity.getNo_Acceso(), entity.getApellido_Paterno(), entity.getApellido_Materno(), entity.getArea());
			   
			   Map<String, Object> mapResponse = new HashMap<>(); 
		        mapResponse.put("mensaje", "Alta Usurio");
				
				return mapResponse;
			   
	}
	
	public Map<String, Object> postElim(UsuarioDto entity){
				   Map<String, Object> mapResponse = new HashMap<>(); 
			        mapResponse.put("mensaje", "Borrado exitoso");
					usuarioRepository.deleteUsuario(entity.getLogin());
					return mapResponse;
		
	}

	@Override
	public Map<String, Object> postMod(UsuarioDto entity) {
		usuarioRepository.modUsuario(entity.getLogin(),
				          Encripta.getEncriptar(entity.getPassword()),
						  entity.getNombre(),
				          entity.getCliente(), entity.getEmail(), entity.getStatus(), entity.getIntentos(), 
				          entity.getNo_Acceso(),entity.getApellido_Paterno(),entity.getApellido_Materno(),entity.getArea());
		 
		Map<String, Object> mapResponse = new HashMap<>(); 
	        mapResponse.put("mensaje", "Modificacion de Usurio");
			
			return mapResponse;
	}
	
	public Map<String, Object> usuEx(UsuarioDto entity){
		   Map<String, Object> mapResponse = new HashMap<>();
		   mapResponse.put("mensaje", "Usuario existente");
			usuarioRepository.usuarioEx(entity.getLogin(),  Encripta.getEncriptar(entity.getPassword())).orElseThrow(()->new EntityNotFoundException("No Encontrado"));
			//entity.getFecha_Vigencia()
			return mapResponse;
				
			}
	public static String getFechaActual() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String strFecha = sdf.format(new Date());
		return strFecha;
	}

	@Override
	public Optional<List<Usuario>> getStatus(String status) {
		// TODO Auto-generated method stub
		return usuarioRepository.usuarioSta(status);
	}

	@Override
	public Optional<List<Usuario>> usuarioNom(String nombre) {
		// TODO Auto-generated method stub
		return usuarioRepository.usuarioNom(nombre);
	}

	@Override
	public Optional<List<Usuario>> usuarioFech(UsuarioDto entity) {
		// TODO Auto-generated method stub
		System.out.println("val"+entity.getFechaAlta() + entity.getFechaFinal());
		return usuarioRepository.usuarioFech(entity.getFechaAlta(), entity.getFechaFinal());
	}
	
}
