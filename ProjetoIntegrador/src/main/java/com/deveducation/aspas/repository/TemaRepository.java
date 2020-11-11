package com.deveducation.aspas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.deveducation.aspas.model.TemaModel;

public interface TemaRepository extends JpaRepositoryImplementation<TemaModel, Long>{
	
	public List<TemaModel> findByMateriaAndSubmateriaContainingIgnoreCase(String materia, String submateria);
	
	public List<TemaModel> findAllByMateriaContainingIgnoreCase(String materia);

}
