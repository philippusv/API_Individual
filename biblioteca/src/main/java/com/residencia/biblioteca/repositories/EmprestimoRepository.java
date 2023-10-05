package com.residencia.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.biblioteca.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository <Emprestimo, Integer>{

}
