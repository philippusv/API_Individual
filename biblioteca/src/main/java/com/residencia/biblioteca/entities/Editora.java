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
codigoeditora serial NOT NULL,
nome varchar(50) NOT NULL,
imagem_nome varchar(255),
imagem_filename varchar(255),
imagem_url varchar(255),	
CONSTRAINT editora_pkey PRIMARY KEY (codigoeditora)
*/

@Entity
@Table(name = "editora")
public class Editora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoeditora")
	private Integer codigoEditora;

	@Column(name = "nome")
	private String nome;

	@Column(name = "imagem_nome")
	private Date imagemNome;

	@Column(name = "imagem_filename")
	private String imagem_FileName;

	@Column(name = "imagem_url")
	private String imagem_Url;
	
	@OneToMany(mappedBy = "editora")
	private List<Livro> livros;

	public Integer getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(Integer codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(Date imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagem_FileName() {
		return imagem_FileName;
	}

	public void setImagem_FileName(String imagem_FileName) {
		this.imagem_FileName = imagem_FileName;
	}

	public String getImagem_Url() {
		return imagem_Url;
	}

	public void setImagem_Url(String imagem_Url) {
		this.imagem_Url = imagem_Url;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	
}
