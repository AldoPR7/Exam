package com.exam.demo.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.demo.entity.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	@Modifying
    @Transactional
    @Query(value ="INSERT INTO USUARIO" +
            " (LOGIN,PASSWORD,NOMBRE,CLIENTE," +
            "  EMAIL,STATUS," +
            "  INTENTOS,NO_ACCESO," +
            "  APELLIDO_PATERNO,APELLIDO_MATERNO,AREA)" +            
            " values (:login, :password, :nombre, :cliente,"+
            ":email, :status,"+
            ":intentos,"+
            ":no_Acceso, :apellido_Paterno, :apellido_Materno, :area)",nativeQuery = true)
		void insertUsuario(@Param("login") String login,
                           @Param("password") String password,
                           @Param("nombre") String nombre,
                           @Param("cliente") String cliente,
                           @Param("email") String email,
                          // @Param("fechaAlta") Date fechaAlta,
                           //@Param("fechaBaja") Date fechaBaja,
                           @Param("status") char status,
                           @Param("intentos") float intentos,
                           //@Param("fechaRevocados") Date fechaRevocado,
                           //@Param("fecha_Vigencia") Date fecha_Vigencia,
                           @Param("no_Acceso") Integer no_Acceso,
                           @Param("apellido_Paterno") String apellido_Paterno,
                           @Param("apellido_Materno") String apellido_Materno,
                           @Param("area") int area);
                           //@Param("fechaModificacion") Date fechaModificacion);
	
	
	@Modifying
    @Transactional
    @Query(value ="DELETE FROM USUARIO WHERE LOGIN=:login" 
            ,nativeQuery = true)
		void deleteUsuario(@Param("login") String login);
	
	
	
	@Modifying
    @Transactional
    @Query(value ="UPDATE USUARIO SET PASSWORD=:password, NOMBRE=:nombre, CLIENTE=:cliente, EMAIL=:email,STATUS=:status,"
    		+ "INTENTOS=:intentos, NO_ACCESO=:no_Acceso, APELLIDO_PATERNO=:apellido_Paterno,"
    		+ " APELLIDO_MATERNO=:apellido_Materno, AREA=:area WHERE LOGIN=:login" 
            ,nativeQuery = true)
		void modUsuario(@Param("login") String login,
							@Param("password") String password,
							@Param("nombre") String nombre,
							@Param("cliente") String cliente,
							@Param("email") String email,
							@Param("status") char status,
							@Param("intentos") float intentos,
							@Param("no_Acceso") Integer no_Acceso,
							@Param("apellido_Paterno") String apellido_Paterno,
							@Param("apellido_Materno") String apellido_materno,
							@Param("area") int area);
	
//A ACTIVOS
//B INACTIVOS
//C REVOCADOS
//	TO_DATE('FECHA_VIGENCIA','YYYYMMDD')

    @Query(value ="SELECT LOGIN FROM USUARIO WHERE LOGIN=:login AND PASSWORD=:password AND to_char(fecha_Vigencia,'YYYYMMDD') <=to_char(current_date,'YYYYMMDD') AND STATUS='A'"
            ,nativeQuery = true)
	Optional<String> usuarioEx(@Param("login") String login,
			@Param("password") String password);
    
    
    
    @Query(value ="SELECT * FROM Usuario U WHERE U.STATUS=:status"
            ,nativeQuery = true)
	Optional<List<Usuario>>  usuarioSta(@Param("status") String status);
			
    
    
    @Query(value ="SELECT * FROM Usuario U WHERE U.NOMBRE=:nombre"
            ,nativeQuery = true)
	Optional<List<Usuario>>  usuarioNom(@Param("nombre") String nombre);
 
    
    @Query(value ="select * from usuario where (fechaAlta) BETWEEN to_date(:fechaInicial,'yyyy/mm/dd') AND to_date(:fechaFinal,'yyyy/mm/dd')"
            ,nativeQuery = true)
	Optional<List<Usuario>>  usuarioFech(@Param("fechaInicial") String fechaInicial,
										 @Param("fechaFinal") String fechaFinal);
    
}
