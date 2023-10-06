package com.residencia.biblioteca.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*
numeromatriculaaluno serial NOT NULL,
	nome varchar(100) NOT NULL,
	datanascimento date NULL,
	cpf bpchar(11) NULL,
	logradouro varchar(100) NULL,
	numerologradouro varchar(10) NULL,
	complemento varchar(50) NULL,
	bairro varchar(50) NULL,
	cidade varchar(50) NULL,
	CONSTRAINT alunos_cpf_key UNIQUE (cpf),
	CONSTRAINT alunos_pkey PRIMARY KEY (numeromatriculaaluno)
 */

@Entity
@Table(name = "aluno") // o table é opcional, utilizado para dar o nome a tabela
public class Aluno {

	// os atributos abaixo são todas as colunas do banco de dados

	@Id // o Id é para informar que a entidade é a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // vai ser usado para gerar um valor automático
	@Column(name = "numeromatriculaaluno") // é opcional
	private Integer numeroMatriculaAluno;

	@Column(name = "nome")
	private String nome;

	@Column(name = "datanascimento")
	private Date dataNascimento;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numeromalogradouro")
	private String numeroLogradouro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cidade")
	private String cidade;
	
	@OneToMany(mappedBy = "aluno")
	private List<Emprestimo> emprestimos;

	public Integer getNumeroMatriculaAluno() {
		return numeroMatriculaAluno;
	}

	public void setNumeroMatricaAluno(Integer numeroMatriculaAluno) {
		this.numeroMatriculaAluno = numeroMatriculaAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
}
