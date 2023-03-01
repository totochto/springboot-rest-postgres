package com.escuela.rest.vo;

import java.util.List;

public class CalificacionesVO {

	public CalificacionesVO() {
		
	}
	
	private ResponseVO respuesta;
	
	private List<CalificacionVO> calificaciones;
	
	private String promedio;

	
	public ResponseVO getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(ResponseVO respuesta) {
		this.respuesta = respuesta;
	}

	public List<CalificacionVO> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<CalificacionVO> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public String getPromedio() {
		return promedio;
	}

	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}
	
	
	
}
