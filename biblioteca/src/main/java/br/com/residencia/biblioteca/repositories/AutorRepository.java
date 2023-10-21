package br.com.residencia.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.biblioteca.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{

}
