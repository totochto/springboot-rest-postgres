package com.escuela.rest.service;

import com.escuela.rest.vo.CalificacionVO;
import com.escuela.rest.vo.CalificacionesVO;
import com.escuela.rest.vo.ResponseVO;

public interface CalificacionesService {

	public ResponseVO guardarCalificacion(CalificacionVO calificacionP);
	
	public CalificacionesVO getCalificacionesByIdAlumno(Integer idAlumno);
	
	public ResponseVO actualizarCalificacion(Integer IdCalificacion, double nvaCalificacion);
	
	public ResponseVO eliminarCalificacion(Integer IdCalificacion);
	
}
