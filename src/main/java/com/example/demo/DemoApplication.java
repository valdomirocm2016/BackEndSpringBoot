package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.resource.Atividade;
import com.example.demo.resource.AtividadeRepository;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private AtividadeRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Atividade a1 = new Atividade();
		a1.setNome("Simpos 2019");
		repo.save(a1);
		

	}

}
