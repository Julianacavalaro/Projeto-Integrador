package com.deveducation.aspas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deveducation.aspas.model.TemaModel;
import com.deveducation.aspas.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	//Injetando o TemaRepository dentro do TemaController
	@Autowired
	private TemaRepository repository;
	
	//Busca quando acessarmos localhost:8080/tema mostra toda a lista
	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	//Busca quando acessarmos localhost:8080/tema/id (get=busca) mostra o erro not found caso nao encontre o Id passado na url
	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	//Busca quando acessarmos localhost:8080/materia por nome
	@GetMapping("/materia/{materia}")
	public ResponseEntity<List<TemaModel>> getByName(@PathVariable String materia){
		return ResponseEntity.ok(repository.findAllByMateriaContainingIgnoreCase(materia));
	}

	@GetMapping("/submateria/{materia}/{submateria}")
	public List<TemaModel> findByMateriaAndSubmateria(@PathVariable String materia, @PathVariable String submateria) {
		return repository.findByMateriaAndSubmateriaContainingIgnoreCase(materia, submateria);
	}
	//Inseri dados na tabela 
	@PostMapping
	public ResponseEntity<TemaModel>post (@RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tema));
	}
	//Altera os dados da tabela
	@PutMapping
	public ResponseEntity<TemaModel> put (@RequestBody TemaModel tema) {
		return ResponseEntity.ok(repository.save(tema));
	}
	//Deleta os dados pelo Id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id_tema) {
		repository.deleteById(id_tema); 
	}
	



	
	
}
