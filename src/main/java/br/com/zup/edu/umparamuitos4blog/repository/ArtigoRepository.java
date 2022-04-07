package br.com.zup.edu.umparamuitos4blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.edu.umparamuitos4blog.model.Artigo;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long>{

}
