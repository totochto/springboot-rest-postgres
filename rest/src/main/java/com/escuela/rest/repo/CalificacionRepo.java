package com.escuela.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.escuela.rest.model.CalificacionDT;

@Repository
public interface CalificacionRepo extends JpaRepository<CalificacionDT, Integer>{

	@Query(value = "SELECT c FROM CalificacionDT c WHERE c.idTUsuarios = ?1")
    public List<CalificacionDT> findByIdUsuario(Integer idUsuario);
	
}
