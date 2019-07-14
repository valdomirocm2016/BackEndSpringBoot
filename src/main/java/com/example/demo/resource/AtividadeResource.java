package com.example.demo.resource;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/*@RequestMapping(path="/atividades")*/
@RestController
public class AtividadeResource {

	@Autowired
	private AtividadeService service;
	
	@RequestMapping(value="/atividade/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		try {
			Atividade atividade = service.buscar(id);
			
			return ResponseEntity.ok().body(atividade);
			
		} catch(NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}		
		
	}
	
	@RequestMapping(value="/atividade",method= RequestMethod.GET)
	public List<Atividade> listar() {
		/*Atividade a1 = new Atividade(1,"visita tecnica gdg");
		Atividade a2 = new Atividade(2,"simpós");
		return Arrays.asList(a1,a2);*/
		
		return service.getAtividades();
	}
	
	@RequestMapping(value="/atividade/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Atividade> deleteAtividade(@PathVariable Integer id){
		
		Atividade atv= service.buscar(id);
		if(atv==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.delete(id);
		
		return new ResponseEntity<Atividade>(HttpStatus.OK);
	}
	 @RequestMapping(value="/atividade",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Atividade> alterarAtividade(@RequestBody Atividade atividade){
		 
	        Atividade atv = service.alterar(atividade);
	        
	        return new ResponseEntity<Atividade>(atv, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value="/atividade", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Atividade> cadastrarCliente(@RequestBody Atividade atividade){
	        Atividade atv = service.cadastrar(atividade);
	        
	        return new ResponseEntity<Atividade>(atv, HttpStatus.CREATED);
	    }
	
	
	
}
