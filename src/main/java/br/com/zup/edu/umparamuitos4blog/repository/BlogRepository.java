package br.com.zup.edu.umparamuitos4blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.edu.umparamuitos4blog.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

}
