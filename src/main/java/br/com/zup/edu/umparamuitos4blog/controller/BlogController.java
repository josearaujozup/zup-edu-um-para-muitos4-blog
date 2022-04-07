package br.com.zup.edu.umparamuitos4blog.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.umparamuitos4blog.model.Blog;
import br.com.zup.edu.umparamuitos4blog.repository.BlogRepository;

@RestController
public class BlogController {
	
	@Autowired
	BlogRepository repository;
	
	@Transactional
	@PostMapping("/api/blogs")
	ResponseEntity<?> cadastrar(@RequestBody @Valid BlogDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Blog blog = request.toModel();
		repository.save(blog);
		
		URI location = uriComponentsBuilder.path("/api/blogs/{id}").buildAndExpand(blog.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
