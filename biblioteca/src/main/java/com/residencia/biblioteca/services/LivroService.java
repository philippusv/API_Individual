package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository livroRepo;
	
	public List<Livro> listarLivro(){
		return livroRepo.findAll();
	}
	
	public Livro buscarLivroPorId(Integer id) {
		return livroRepo.findById(id).orElse(null);
	}
	
	public Livro salvarLivro(Livro livro) {
		return livroRepo.save(livro);
	}
	
	public Livro atualizarLivro(Livro livro) {
		return livroRepo.save(livro);
	}
	
	public Boolean deletarLivro(Livro livro) {
		if (livro == null)
			return false;

		Livro livroExistente = buscarLivroPorId(livro.getCodigoIsbn());
		if (livroExistente == null)
			return false;

		livroRepo.delete(livro);

		Livro livroContinuaExistindo = buscarLivroPorId(livro.getCodigoIsbn());
		if (livroContinuaExistindo == null)
			return true;

		return false;
	}
}
