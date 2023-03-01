package com.escuela.rest.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.escuela.rest.model.AlumnoDT;


public interface AlumnoRepo extends JpaRepository<AlumnoDT, Integer>{

	@Query(value = "SELECT al FROM AlumnoDT al WHERE al.id = ?1")
	Optional<AlumnoDT> findById(Integer idAlumno);
	
}
