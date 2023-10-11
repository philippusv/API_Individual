package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Autor;
import com.residencia.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepo;
	
	public List<Autor> listarAutores(){
		return autorRepo.findAll();
	}
	
	public Autor buscarAutorPorId(Integer Id) {
		return autorRepo.findById(Id).orElse(null);
	}
	
	public Autor salvarAutor(Autor autor) {
		return autorRepo.save(autor);
	}

	public Autor atualizarAutor(Autor autor) {
		return autorRepo.save(autor);
	}
	
	public Boolean deletarAutor(Autor autor) {
		if (autor == null)
			return false;

		Autor autorExistente = buscarAutorPorId(autor.getCodigoAutor());
		if (autorExistente == null)
			return false;

		autorRepo.delete(autor);

		Autor autorContinuaExistindo = buscarAutorPorId(autor.getCodigoAutor());
		if (autorContinuaExistindo == null)
			return true;

		return false;
	}
}
