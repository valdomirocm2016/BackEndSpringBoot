package com.example.demo.resource;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atividade implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String string) {
		// TODO Auto-generated method stub
		this.nome=string;
		
	}

	
	//construtores, gets e sets
	public Atividade() {
		
	}
	
	public Atividade (int id, String nome) {
	     this.id=id;
	     this.nome=nome;
	}

	

	public Atividade get() {
		// TODO Auto-generated method stub
		return new Atividade(id,nome);
	}
}
