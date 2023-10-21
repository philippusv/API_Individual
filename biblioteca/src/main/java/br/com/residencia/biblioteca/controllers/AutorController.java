package br.com.residencia.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.biblioteca.entities.Autor;
import br.com.residencia.biblioteca.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService service;
	
	// findAll
	@GetMapping
	public ResponseEntity<List<Autor>> listarTudo() {
		return new ResponseEntity<>(service.listarTudo(), HttpStatus.OK);
	}
	
	// findById
	@GetMapping("/{id}")
	public ResponseEntity<Autor> buscarPorId(@PathVariable Integer id) {
		Autor autor = service.buscarPorId(id);
		if(autor == null) {
			return new ResponseEntity<>(autor, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(autor, HttpStatus.OK);
		}
	}
	
	// create
	@PostMapping
	public ResponseEntity<Autor> criar(@RequestBody Autor autor) {
		return new ResponseEntity<>(service.criar(autor), HttpStatus.CREATED);
	}
	
	// update
	@PutMapping
	public ResponseEntity<Autor> atualizar(@RequestBody Autor autor) {
		return new ResponseEntity<>(service.atualizar(autor), HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping
	public ResponseEntity<String> deletar(@RequestBody Autor autor) {
		if(service.deletar(autor) == true) {
			return new ResponseEntity<>("Deletado com Sucesso!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
		}
	}
}
