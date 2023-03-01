package com.escuela.rest.model;


import javax.persistence.*;

@Entity
@Table(name = "t_alumnos")

public class AlumnoDT {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_usuarios", nullable = false)
    private Integer id;
 
    @Column(name = "nombre", length = 80)
    private String nombre;

    @Column(name = "ap_paterno", length = 80)
    private String apPaterno;

    @Column(name = "ap_materno", length = 80)
    private String apMaterno;

    @Column(name = "activo")
    private Integer activo;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}	
    
    

}
