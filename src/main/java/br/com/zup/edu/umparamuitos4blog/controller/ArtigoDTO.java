package br.com.zup.edu.umparamuitos4blog.controller;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.edu.umparamuitos4blog.model.Artigo;
import br.com.zup.edu.umparamuitos4blog.model.Blog;
import br.com.zup.edu.umparamuitos4blog.model.Tipo;

public class ArtigoDTO {
	
	@NotBlank
	@Size(max=200)
	private String titulo;
	
	@NotBlank
	@Size(max=10000)
	private String corpo;
	
	@NotNull
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

	public ArtigoDTO(@NotBlank @Size(max = 200) String titulo, @NotBlank @Size(max = 10000) String corpo,
			@NotNull Tipo tipo) {
		this.titulo = titulo;
		this.corpo = corpo;
		this.tipo = tipo;
	}
	
	public ArtigoDTO() {}
	
	public String getTitulo() {
		return titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Artigo toModel(Blog blog) {
		return new Artigo(titulo, corpo, tipo, blog);
	}
	
}
