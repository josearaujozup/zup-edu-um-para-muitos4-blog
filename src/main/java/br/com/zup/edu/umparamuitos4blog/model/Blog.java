package br.com.zup.edu.umparamuitos4blog.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Blog {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	public LocalDateTime criadoEm=LocalDateTime.now();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "blog")
	private List<Artigo> artigos = new ArrayList<>();

	public Blog(String nome) {
		this.nome = nome;
	}
	
	/**
     * @deprecated construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Blog() {
    	
    }
	
    public Long getId() {
        return id;
    }

    public void adicionar(Artigo artigo) {
        this.artigos.add(artigo);
    }
    
}
