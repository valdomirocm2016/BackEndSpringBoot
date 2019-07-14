package com.example.demo.resource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer>{
	
	//@Query("Select a from Atividade a where a.nome like %:nome%")
	public List<Atividade> findByNomeContaining(@Param("nome") String nome);

}