package br.com.residencia.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.biblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository <Livro, Integer>{

}
