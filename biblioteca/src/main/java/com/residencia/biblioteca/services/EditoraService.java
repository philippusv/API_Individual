package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {
	@Autowired
	EditoraRepository editoraRepo;
	
	public List<Editora> listarEditoras(){
		return editoraRepo.findAll();
	}
	
	public Editora buscarEditoraPorId(Integer id) {
		return editoraRepo.findById(id).orElse(null);
	}
	
	public Editora salvarEditora(Editora editora) {
		return editoraRepo.save(editora);
	}
	
	public Editora atualizarEditora(Editora editora) {
		return editoraRepo.save(editora);
	}
	
	public Boolean deletarEditora(Editora editora) {
		if (editora == null)
			return false;

		Editora editoraExistente = buscarEditoraPorId(editora.getCodigoEditora());
		if (editoraExistente == null)
			return false;

		editoraRepo.delete(editora);

		Editora editoraContinuaExistindo = buscarEditoraPorId(editora.getCodigoEditora());
		if (editoraContinuaExistindo == null)
			return true;

		return false;
	}
}
