package com.escuela.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.rest.service.CalificacionesService;
import com.escuela.rest.vo.CalificacionVO;
import com.escuela.rest.vo.CalificacionesVO;
import com.escuela.rest.vo.ResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(value = "/escuela")
public class RestControllerC {

	@Autowired
	CalificacionesService calificacionesService;
	
	
	@Operation(summary = "Guardar Calificación")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Calificación Registrada")
							, @ApiResponse(responseCode = "500", description = "Error interno")
							} 
					)
	@PostMapping(value = "/guardarCalificacion/")
	public ResponseEntity<ResponseVO> guardarCalificacion(@RequestBody CalificacionVO calificacion) {
		ResponseVO respCalificacion =  calificacionesService.guardarCalificacion(calificacion);
		
		if(respCalificacion.getCodigo() == 0) {
			return new ResponseEntity<ResponseVO>(respCalificacion, HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@Operation(summary = "Lista de Calificaciones")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Lista de Calificaciones")
							, @ApiResponse(responseCode = "500", description = "Error interno")
							} 
					)
	@GetMapping(value = "/getCalificaciones/{idAlumno}")
	public ResponseEntity<CalificacionesVO> getCalificaciones(@PathVariable("idAlumno") String idAlumno) {
		CalificacionesVO calificaciones = calificacionesService.getCalificacionesByIdAlumno(Integer.valueOf(idAlumno));
		
		if(calificaciones.getRespuesta().getCodigo() == 200) {
			return new ResponseEntity<CalificacionesVO>(calificaciones, HttpStatus.OK);
		} else {
			return new ResponseEntity<CalificacionesVO>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	
	@Operation(summary = "Calificación Actualizada")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Calificación Actualizada")
							, @ApiResponse(responseCode = "500", description = "Error interno")
							} 
					)
	@PutMapping(value = "/getCalificaciones/{idCalificacion}/{nvaCalificacion}")
	public ResponseEntity<ResponseVO> actualizarCalificaciones(
			@PathVariable("idCalificacion") String idCalificacion
			, @PathVariable("nvaCalificacion") String nvaCalificacion) {
		ResponseVO respCalificacion =  calificacionesService.actualizarCalificacion(Integer.valueOf(idCalificacion), Double.valueOf(nvaCalificacion));
		
		if(respCalificacion.getCodigo() == 0) {
			return new ResponseEntity<ResponseVO>(respCalificacion, HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@Operation(summary = "Calificación Eliminada")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Calificación Eliminada")
							, @ApiResponse(responseCode = "500", description = "Error interno")
							} 
					)
	@DeleteMapping(value = "/getCalificaciones/{idCalificacion}")
	public ResponseEntity<ResponseVO> eliminarCalificaciones(@PathVariable("idCalificacion") String idCalificacion) {
		ResponseVO respCalificacion =  calificacionesService.eliminarCalificacion(Integer.valueOf(idCalificacion));
		
		if(respCalificacion.getCodigo() == 0) {
			return new ResponseEntity<ResponseVO>(respCalificacion, HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
}
