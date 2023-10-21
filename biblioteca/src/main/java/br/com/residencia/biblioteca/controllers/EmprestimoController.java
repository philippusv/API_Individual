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

import br.com.residencia.biblioteca.entities.Emprestimo;
import br.com.residencia.biblioteca.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoService service;
	
	@GetMapping
	public ResponseEntity<List<Emprestimo>> listarTudo() {
		return new ResponseEntity<>(service.listarTudo(), HttpStatus.OK);
		// outro jeito de fazer
		// ResponseEntity.ok(service.listarTudo())
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> buscarPorId(@PathVariable Integer id) {
		Emprestimo emprestimo = service.buscarPorId(id);
		if(emprestimo == null) {
			return new ResponseEntity<>(emprestimo, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(emprestimo, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Emprestimo> criar(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(service.criar(emprestimo), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Emprestimo> atualizar(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(service.atualizar(emprestimo), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletar(@RequestBody Emprestimo emprestimo) {
		if(service.deletar(emprestimo) == true) {
			return new ResponseEntity<>("Deletado com Sucesso!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
		}
	}
	
}
