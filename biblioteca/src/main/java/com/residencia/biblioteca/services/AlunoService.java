package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {
	
//CRUD
//recuperar todos os alunos
//recuperar um aluno pela sua chave primária
//salvar um novo aluno
//atualizar um determinado aluno
//deletar um determinado aluno
	
	@Autowired  // essa anotação é para injeção de dependencia, recursos de outro lugar
	AlunoRepository alunoRepo;
	
	public List<Aluno> listarAlunos(){
		return alunoRepo.findAll();
	}
	
	public Aluno buscarAlunoPorId(Integer id) {
		return alunoRepo.findById(id).get();
	}
	
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public void deletarAluno(Aluno aluno) {
		alunoRepo.delete(aluno);
		//Aluno confereAlunoDeletado = buscarAlunoPorId(aluno.getNumeroMatricaAluno());
	}
}
