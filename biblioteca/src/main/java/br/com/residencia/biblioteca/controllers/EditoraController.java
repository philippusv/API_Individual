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

import br.com.residencia.biblioteca.dto.EditoraDTO;
import br.com.residencia.biblioteca.entities.Editora;
import br.com.residencia.biblioteca.services.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	private EditoraService service;
	
	@GetMapping
	public ResponseEntity<List<Editora>> listarTudo() {
		return new ResponseEntity<>(service.listarTudo(), HttpStatus.OK);
		// outro jeito de fazer
		// ResponseEntity.ok(service.listarTudo())
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Editora> buscarPorId(@PathVariable Integer id) {
		Editora editora = service.buscarPorId(id);
		if(editora == null) {
			return new ResponseEntity<>(editora, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(editora, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Editora> criar(@RequestBody Editora editora) {
		return new ResponseEntity<>(service.criar(editora), HttpStatus.CREATED);
	}
	
	@PostMapping("/dto")
	public ResponseEntity<EditoraDTO> criarDTO(@RequestBody EditoraDTO editoraDTO) {
		return new ResponseEntity<>(service.criarDTO(editoraDTO), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Editora> atualizar(@RequestBody Editora editora) {
		return new ResponseEntity<>(service.atualizar(editora), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletar(@RequestBody Editora editora) {
		if(service.deletar(editora) == true) {
			return new ResponseEntity<>("Deletado com Sucesso!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
		}
	}
	
}
