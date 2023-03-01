package com.escuela.rest.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuela.rest.model.AlumnoDT;
import com.escuela.rest.model.CalificacionDT;
import com.escuela.rest.repo.AlumnoRepo;
import com.escuela.rest.repo.MateriaRepo;
import com.escuela.rest.repo.CalificacionRepo;
import com.escuela.rest.service.CalificacionesService;
import com.escuela.rest.vo.CalificacionVO;
import com.escuela.rest.vo.CalificacionesVO;
import com.escuela.rest.vo.ResponseVO;

@Service
public class CalificacionesServiceImpl implements CalificacionesService{
	
	@Autowired
	AlumnoRepo alumnoRepo;
	
	@Autowired
	MateriaRepo materiaRepo;
	
	@Autowired
	CalificacionRepo calificacionRepo;
	
	/**
	 * Registro de calificación por alumno
	 * @param calificacionP
	 * @return
	 */
	public ResponseVO guardarCalificacion(CalificacionVO calificacionP) {
		ResponseVO respuesta = new ResponseVO();
		CalificacionDT califTable = new CalificacionDT();

		califTable.setIdTUsuarios(Integer.parseInt(calificacionP.getId_t_usuarios()));
		califTable.setIdTMaterias(materiaRepo.findById(calificacionP.getId_materia()).get());
		califTable.setCalificacion(Double.parseDouble(calificacionP.getCalificacion()));
		califTable.setFechaRegistro(new Date());
		calificacionRepo.save(califTable);
		
		respuesta.setCodigo(0);
		respuesta.setMensaje("Calificacion registrada");
		
		return respuesta;
	}
	
	
	/**
	 * Obtiene las calificaciones de un alumno determinado
	 * @param idAlumno
	 * @return
	 */
	public CalificacionesVO getCalificacionesByIdAlumno(Integer idAlumno){
		List<CalificacionDT> calificacionesT = new ArrayList<>();
		List<CalificacionVO> calificacionesL = new ArrayList<>();
		List<CalificacionesVO> calificacionesF = new ArrayList<>();
		CalificacionesVO califs = new CalificacionesVO();
		CalificacionVO calif = new CalificacionVO();
		ResponseVO resp = new ResponseVO();
		double promedio = 0.0;
		int cont = 0;
		SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
		
		Optional<AlumnoDT> alumn = alumnoRepo.findById(idAlumno);
		
		calificacionesT = calificacionRepo.findByIdUsuario(alumn.get().getId());

		for(int i=0; i<calificacionesT.size(); i++){
			calif = new CalificacionVO();
			calif.setId_t_usuarios(alumn.get().getId().toString());
			calif.setNombre(alumn.get().getNombre());
			calif.setAp_paterno(alumn.get().getApPaterno());
			calif.setAp_materno(alumn.get().getApMaterno());
			calif.setMateria(calificacionesT.get(i).getIdTMaterias().getNombre());
			calif.setCalificacion(calificacionesT.get(i).getCalificacion().toString());
			calif.setFechaRegistro(sdformat.format(calificacionesT.get(i).getFechaRegistro()));
			
			promedio+=calificacionesT.get(i).getCalificacion();
			cont++;
			
			calificacionesL.add(calif);
		}
		
		resp.setCodigo(200);
		resp.setMensaje("Respuesta ok");
		
		califs.setRespuesta(resp);
		califs.setCalificaciones(calificacionesL);
		califs.setPromedio(String.valueOf(promedio/cont));
		calificacionesF.add(califs);
		
		return califs;
	}
	
	
	/**
	 * Actualización de una calificación
	 * @param IdCalificacion
	 * @param nvaCalificacion
	 * @return
	 */
	public ResponseVO actualizarCalificacion(Integer IdCalificacion, double nvaCalificacion) {
		ResponseVO respuesta = new ResponseVO();
		CalificacionDT califTable = new CalificacionDT();
		Optional <CalificacionDT> califFound = calificacionRepo.findById(IdCalificacion);
		califTable = califFound.get();
		
		if(califFound.isPresent()){
			califTable.setCalificacion(nvaCalificacion);
			calificacionRepo.save(califTable);
			
			respuesta.setCodigo(0);
			respuesta.setMensaje("Calificacion actualizada");
		} else {
			respuesta.setCodigo(-1);
			respuesta.setMensaje("Calificacion inexistente");
		}
		

		
		return respuesta;
	} 
	
	
	/**
	 * Borrado de una calificación
	 * @param IdCalificacion
	 * @param nvaCalificacion
	 * @return
	 */
	public ResponseVO eliminarCalificacion(Integer IdCalificacion) {
		ResponseVO respuesta = new ResponseVO();
		
		if(calificacionRepo.findById(IdCalificacion).isPresent()){
			calificacionRepo.deleteById(IdCalificacion);
			
			respuesta.setCodigo(0);
			respuesta.setMensaje("Calificacion eliminada");
		} else {
			respuesta.setCodigo(-1);
			respuesta.setMensaje("Calificacion inexistente");
		}
		
		return respuesta;
	} 
	
	

}
