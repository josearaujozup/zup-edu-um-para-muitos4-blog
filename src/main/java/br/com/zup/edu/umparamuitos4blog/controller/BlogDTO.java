package br.com.zup.edu.umparamuitos4blog.controller;

import javax.validation.constraints.NotBlank;

import br.com.zup.edu.umparamuitos4blog.model.Blog;

public class BlogDTO {
	
	@NotBlank
	private String nome;

	public BlogDTO(String nome) {
		this.nome = nome;
	}
	
	public BlogDTO() {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Blog toModel() {
		return new Blog(nome);
	}
	
}
