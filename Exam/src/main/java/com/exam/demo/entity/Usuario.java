package com.exam.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario {
	
	  @Id
      @Column(name = "LOGIN")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String login;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "CLIENTE")
	private Float cliente;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FECHAALTA")
	private Date fechaAlta;
	
	@Column(name = "FECHABAJA")
	private Date fechaBaja;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "INTENTOS")
	private Float intentos;
	
	@Column(name = "FECHAREVOCADO")
	private Date fechaRevocado;
	
	@Column(name = "FECHA_VIGENCIA")
	private Date fechaVigencia;
	
	@Column(name = "NO_ACCESO")
	private Integer noAcceso;
	
	@Column(name = "APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	@Column(name = "APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	@Column(name = "AREA")
	private int area;
	
	@Column(name = "FECHAMODIFICACION")
	private Date fechaMoficacion;
}
