package br.com.zup.edu.umparamuitos4blog.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.umparamuitos4blog.model.Artigo;
import br.com.zup.edu.umparamuitos4blog.model.Blog;
import br.com.zup.edu.umparamuitos4blog.repository.ArtigoRepository;
import br.com.zup.edu.umparamuitos4blog.repository.BlogRepository;

@RestController
public class ArtigoController {
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	ArtigoRepository artigoRepository;
	
	@Transactional
	@PostMapping("/api/blogs/{idBlog}/artigos")
	ResponseEntity<?> cadastrar(@PathVariable Long idBlog, @RequestBody @Valid ArtigoDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Blog blog = blogRepository.findById(idBlog).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro de blog para o id informado"));
		
		Artigo artigo = request.toModel(blog);
		blog.adicionar(artigo);
		
//		blogRepository.save(blog);
		artigoRepository.save(artigo);
		
		URI location = uriComponentsBuilder.path("/api/blogs/{idBlog}/artigos/{id}").buildAndExpand(blog.getId(),artigo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
