package com.escuela.rest.vo;


public class CalificacionVO {
	
	public CalificacionVO() {
		
	}
	
    private String id_t_usuarios;

    private String nombre;

    private String ap_paterno;

    private String ap_materno;
    
    private Integer id_materia;
    
    private String materia;
    
    private String calificacion;

    private String fechaRegistro;
    

	public String getId_t_usuarios() {
		return id_t_usuarios;
	}

	public void setId_t_usuarios(String id_t_usuarios) {
		this.id_t_usuarios = id_t_usuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}
	
	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



}
