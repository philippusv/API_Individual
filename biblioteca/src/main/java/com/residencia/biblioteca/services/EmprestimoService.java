package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepo;
	
	public List<Emprestimo> listarEmprestimo(){
		return emprestimoRepo.findAll();
	}
	
	public Emprestimo buscarEmprestimoPorId(Integer id) {
		return emprestimoRepo.findById(id).get();
	}
	
	public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepo.save(emprestimo);
	}
	
	public Emprestimo atualizarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepo.save(emprestimo);
	}
	
	public void deletarEmprestimo(Emprestimo emprestimo) {
		emprestimoRepo.delete(emprestimo);
	}

}
