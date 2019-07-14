package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository repo;
	
	public Atividade buscar(Integer id) {
		
		return repo.findById(id).get();
	}
	public void delete(Integer id) {
		
		repo.deleteById(id);	
	}
	public List<Atividade> getAtividades() {
		
		return repo.findAll();
	}
	public Atividade cadastrar(Atividade atividade) {
		
		return repo.save(atividade);
	}
	public Atividade alterar(Atividade atividade) {
		
		return repo.save(atividade);
	}
}
