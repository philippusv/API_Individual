package br.com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.dto.AlunoDTO;
import br.com.residencia.biblioteca.entities.Aluno;
import br.com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	// read
	/**
	 * Método que lista todos os alunos encontrados
	 * @return Retorna uma lista de alunos.
	 */
	public List<Aluno> listarTudo() {
		return repository.findAll();
	}
	
	// read by id, recupera todo o objeto
	public Aluno buscarPorId(Integer id) {
		// primeira versao
		//return repository.findById(id).get();		
		
		/* versao com excecao
		 return repository.findById(id).orElseThrow(() -> new RuntimeException());
		 */
		
		/*
		 * Optional<Aluno> alunoBanco = alunoRepo.findById(id);
			if(alunoBanco.isPresent())
				return alunoBanco.get();
			else
				return null;
		 */
		// versão de uma linha
		return repository.findById(id).orElse(null);
	}
	
	// recupera todos os alunos com o filtro do DTO
	public List<AlunoDTO> listarTudoDTO() {
		
		// cria uma lista de cada entidade
		List<Aluno> alunos = repository.findAll();
		List<AlunoDTO> alunosDTO = new ArrayList<>();
		
		// faz um forEach que percorre o tamanho da lista de alunos, a cada interação vai 
		// quando o tipo de dado se trata de um List, normalmente utiliza-se o for-each
		// estrutura: for(Tipo apelido : coleção)
		for(Aluno aluno : alunos) {
			
			// cria um novo objeto a cada novo aluno encontrado na lista
			AlunoDTO alunoDTO = new AlunoDTO();
			
			// setta os valores do DTO
	        alunoDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
	        alunoDTO.setNome(aluno.getNome());
	        alunoDTO.setCpf(aluno.getCpf());
	        
	        // adiciona na lista ao final do loop
	        alunosDTO.add(alunoDTO);
		}

		return alunosDTO;
	}
	
	// read by id, recupera informações específicas do DTO
	public AlunoDTO buscarPorIdDTO(Integer id) {
		
		Aluno aluno = repository.findById(id).orElse(null);
		
		if(aluno != null) {
			// pode fazer assim: 
			
			// AlunoDTO alunoDTO = new AlunoDTO(aluno.getNumeroMatriculaAluno(), aluno.getNome(), aluno.getCpf());
			// return alunoDTO;
			
			// ou assim:
			// AlunoDTO alunoDTO = new AlunoDTO();
			// alunoDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
			// alunoDTO.setNome(aluno.getNome());
			// alunoDTO.setCpf(aluno.getCpf());
			
			return new AlunoDTO(aluno.getNumeroMatriculaAluno(), aluno.getNome(), aluno.getCpf());
		}
		
		return null;
	}
	
	// create, aqui ele está criando um aluno, quando cria um aluno n dá a coluna de ID
	public Aluno criar(Aluno aluno) {
		return repository.save(aluno);
	}
	
	// update, aqui ele está atualizando um aluno, ele diferencia por causa do ID 
	// quando atualiza tem que botar o ID
	public Aluno atualizar(Aluno aluno) {
		return repository.save(aluno);
	}
	
	// delete pelo objeto 
	public Boolean deletar(Aluno aluno) {
		
		if(aluno == null) {
			return false;
		}
		
		Aluno alunoExist = buscarPorId(aluno.getNumeroMatriculaAluno());
		
		if(alunoExist == null) {
			return false;
		}
		/*
		 * dá p fazer desse jeito tbm
		 * if(alunoExist == null) {
			return false;
			}
			else {
				repository.delete(aluno);
				return true;
			}
		 */
		repository.delete(aluno);
		
		Aluno alunoContinuaExist = buscarPorId(aluno.getNumeroMatriculaAluno());
		
		if(alunoContinuaExist == null) {
			return true;
		}
		
		return false;
	}
	
	/* delete pelo ID 
	public void deletarAluno(Integer id) {
		repository.deleteById(id);
	} */
	
}
