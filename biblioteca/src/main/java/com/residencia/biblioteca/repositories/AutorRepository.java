package com.residencia.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.biblioteca.entities.Autor;

public interface AutorRepository extends JpaRepository <Autor, Integer>{

}
