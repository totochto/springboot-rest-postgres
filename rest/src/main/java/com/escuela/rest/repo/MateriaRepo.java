package com.escuela.rest.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.escuela.rest.model.MateriaDT;

public interface MateriaRepo extends JpaRepository<MateriaDT, Integer> {

	@Query(value = "SELECT m FROM MateriaDT m WHERE m.id = ?1")
	public Optional<MateriaDT> findById(Integer idMateria);
	
}
