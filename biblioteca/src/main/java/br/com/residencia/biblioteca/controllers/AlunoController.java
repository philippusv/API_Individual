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

import br.com.residencia.biblioteca.dto.AlunoDTO;
import br.com.residencia.biblioteca.entities.Aluno;
import br.com.residencia.biblioteca.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService service;
	
	
	// mostra todos os alunos
	@GetMapping
	public ResponseEntity<List<Aluno>> listarTudo() {
		return new ResponseEntity<>(service.listarTudo(), HttpStatus.OK);
		// outro jeito de fazer
		// ResponseEntity.ok(service.listarTudo())
	}
	
	// mostra todos os alunos com as informações do DTO
	@GetMapping("/dto")
	public ResponseEntity<List<AlunoDTO>> listarTudoDTO() {
		return new ResponseEntity<>(service.listarTudoDTO(), HttpStatus.OK);
	}
	
	
	// buscar pelo id sem o DTO, aparece toda a entidade
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id) {
		Aluno aluno = service.buscarPorId(id);
		if(aluno == null) {
			return new ResponseEntity<>(aluno, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(aluno, HttpStatus.OK);
		}
	}
	
	// busca pelo dto, mostra informações específicas do DTO.
	@GetMapping("/dto/{id}")
	public ResponseEntity<AlunoDTO> buscarPorIdDTO(@PathVariable Integer id) {
		AlunoDTO alunoDTO = service.buscarPorIdDTO(id);
		if(alunoDTO == null) {
			return new ResponseEntity<>(alunoDTO, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(alunoDTO, HttpStatus.OK);
		}
	}
	
	/* Outra forma de fazer
	 * @GetMapping("/porid")
	public ResponseEntity<Aluno> buscarAlunoPorId(@RequestParam Integer id) {
		return new ResponseEntity<>(alunoService.buscarAlunoPorId(id), HttpStatus.OK);
	}
	 */
	
	@PostMapping
	public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(service.criar(aluno), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(service.atualizar(aluno), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletar(@RequestBody Aluno aluno) {
		if(service.deletar(aluno) == true) {
			return new ResponseEntity<>("Deletado com Sucesso!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
		}
	}
	
}
