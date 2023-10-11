package com.residencia.biblioteca.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<Aluno>> listarAlunos() {
		return new ResponseEntity<>(alunoService.listarAlunos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id) {
		Aluno aluno = alunoService.buscarAlunoPorId(id);
		if (aluno == null)
			return new ResponseEntity<>(aluno, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(aluno, HttpStatus.OK);
	}

	@GetMapping("/porid")
	public ResponseEntity<Aluno> buscarAlunoPorId(@RequestParam Integer id) {
		return new ResponseEntity<>(alunoService.buscarAlunoPorId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.salvarAluno(aluno), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.atualizarAluno(aluno), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarAluno(@RequestBody Aluno aluno) {
		if (Boolean.TRUE.equals(alunoService.deletarAluno(aluno))) {
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Não foi possivel deletar", HttpStatus.BAD_REQUEST);
		}
	}
}
