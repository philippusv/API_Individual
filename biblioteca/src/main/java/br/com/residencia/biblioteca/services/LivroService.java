package br.com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.dto.LivroDTO;
import br.com.residencia.biblioteca.entities.Livro;
import br.com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	EmailService emailService;
	
	// read
	public List<Livro> listarTudo() {
		return repository.findAll();
	}
	
	// read
	public List<LivroDTO> listarTudoDTO() {
		
		List<Livro> livros = repository.findAll();
		List<LivroDTO> livrosDTO = new ArrayList<>();
				
		// faz um forEach que percorre o tamanho da lista de livros, a cada interação vai 
		for(Livro livro : livros) {
					
			// cria um novo objeto a cada novo livro encontrado na lista
			LivroDTO livroDTO = new LivroDTO();
					
			// setta os valores do DTO
			livroDTO.setCodigoLivro(livro.getCodigoLivro());
			livroDTO.setNomeLivro(livro.getNomeLivro());
			livroDTO.setDataLancamento(livro.getDataLancamento());
			livroDTO.setNomeEditora(livro.getEditora().getNome());
			        
			// adiciona na lista ao final do loop
			livrosDTO.add(livroDTO);
		}

		return livrosDTO;
	}
	
	// read by id
	public Livro buscarPorId(Integer id) {
		// primeira versao
		//return repository.findById(id).get();	
		return repository.findById(id).orElse(null);
	}
	
	// dto by id
	public LivroDTO buscarPorIdDTO(Integer id) {
		
		Livro livro = repository.findById(id).orElse(null);
		if(livro != null) {
			return new LivroDTO(livro.getCodigoLivro(), 
					livro.getNomeLivro(), livro.getDataLancamento(), 
					livro.getEditora().getNome());
		}
		
		return null;
	}
	
	// create, aqui ele está criando um livro, quando cria um livro n dá a coluna de ID
	public Livro criar(Livro livro) {
		Livro newLivro = repository.save(livro);
		// email que vai receber 
		emailService.enviarEmail("felipe123@gmail.com", "Novo livro cadastrado", newLivro.toString());
		return newLivro;
	}
	
	// update, aqui ele está atualizando um livro, ele diferencia por causa do ID 
	// quando atualiza tem que botar o ID
	public Livro atualizar(Livro livro) {
		return repository.save(livro);
	}
	
	// delete pelo objeto 
	public boolean deletar(Livro livro) {
		if(livro == null) {
			return false;
		}
		
		Livro livroExist = buscarPorId(livro.getCodigoLivro());
		
		if(livroExist == null) {
			return false;
		}
		
		repository.delete(livro);
		
		Livro livroContinuaExist = buscarPorId(livro.getCodigoLivro());
		
		if(livroContinuaExist == null) {
			return true;
		}
		
		return false;
	}
	
}
