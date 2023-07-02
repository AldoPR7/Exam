package com.exam.demo.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.exam.demo.entity.Usuario;
import com.exam.demo.tdo.UsuarioDto;

public  interface UsuarioService{
	
	 List<Usuario> getBuscaUsuario();
	 Map<String, Object> postAlta(UsuarioDto entity);
	 Map<String, Object> postElim(UsuarioDto entity);
	 Map<String, Object> postMod(UsuarioDto entity);
	 Map<String, Object> usuEx(UsuarioDto entity);
	 Optional<List<Usuario>> getStatus(String status);
	 Optional<List<Usuario>>  usuarioNom(String nombre);
	 Optional<List<Usuario>>  usuarioFech(UsuarioDto entity);
}
