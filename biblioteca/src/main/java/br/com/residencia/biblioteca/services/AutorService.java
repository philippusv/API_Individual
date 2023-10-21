package br.com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entities.Autor;
import br.com.residencia.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;
	
	
	// findAll
	public List<Autor> listarTudo() {
		return repository.findAll();
	}
	
	// findById
	public Autor buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	// create
	public Autor criar(Autor autor) {
		return repository.save(autor);
	}
	// update
	
	public Autor atualizar(Autor autor) {
		return repository.save(autor);
	}
	
	// delete
	public boolean deletar(Autor autor) {
		if(autor == null) {
			return false;
		}
		
		Autor autorExist = buscarPorId(autor.getCodigoAutor());
		
		if(autorExist == null) {
			return false;
		}
		
		repository.delete(autor);
		
		Autor autorContinuaExist = buscarPorId(autor.getCodigoAutor());
		
		if(autorContinuaExist == null) {
			return true;
		}
		
		return false;
	}
}
