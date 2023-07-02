package com.exam.demo.tdo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
private String login;
private String password;
private String nombre;
private String cliente;
private String email;
private String fechaAlta;
private String fechaFinal;
private char status;
private float intentos;
private String fecha_Vigencia;
private Integer no_Acceso;
private String apellido_Paterno;
private String apellido_Materno;
private int area;
}



