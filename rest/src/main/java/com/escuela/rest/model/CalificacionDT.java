package com.escuela.rest.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "t_calificaciones")
public class CalificacionDT {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones", nullable = false)
    private Integer idTCalificaciones;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_t_materias", nullable = false)
    private MateriaDT idTMaterias;

    @Column(name = "id_t_usuarios", nullable = false)
    private Integer idTUsuarios;

    @Column(name = "calificacion", precision = 10, scale = 2)
    private Double calificacion;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

	public Integer getIdTCalificaciones() {
		return idTCalificaciones;
	}

	public void setIdTCalificaciones(Integer idTCalificaciones) {
		this.idTCalificaciones = idTCalificaciones;
	}

	public MateriaDT getIdTMaterias() {
		return idTMaterias;
	}

	public void setIdTMaterias(MateriaDT idTMaterias) {
		this.idTMaterias = idTMaterias;
	}

	public Integer getIdTUsuarios() {
		return idTUsuarios;
	}

	public void setIdTUsuarios(Integer idTUsuarios) {
		this.idTUsuarios = idTUsuarios;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
    
    

}
