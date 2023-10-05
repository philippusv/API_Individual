package com.residencia.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.biblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository <Livro, Integer>{

}
