package com.residencia.biblioteca.entities;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*
 codigolivro serial NOT NULL,
	nomelivro varchar(120) NOT NULL,
	nomeautor varchar(100) NULL,
	datalancamento date NULL,
	codigoisbn int4 NOT NULL,
	codigoeditora int4 NOT NULL,
	CONSTRAINT livros_pkey PRIMARY KEY (codigolivro)
*/
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigoLivro")

@Entity
@Table(name = "livro")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigolivro")
	private Integer codigoLivro;

	@Column(name = "nomelivro")
	private String nomeLivro;


	@Column(name = "datalancamento")
	private Date dataLancamento;

	@Column(name = "codigoisbn")
	private Integer codigoIsbn;
	
	/*@JsonManagedReference(value = "livro-mng-ref")*/
    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimos;
	
	/*@JsonBackReference(value = "editora-mng-ref")*/
	@ManyToOne
	@JoinColumn(name = "codigoeditora", referencedColumnName = "codigoeditora")
	private Editora editora;
	
	@ManyToOne
	@JoinColumn(name = "codigoautor", referencedColumnName = "codigoautor")
	private Autor autor;

	public Integer getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Integer codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getCodigoIsbn() {
		return codigoIsbn;
	}

	public void setCodigoIsbn(Integer codigoIsbn) {
		this.codigoIsbn = codigoIsbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
}
