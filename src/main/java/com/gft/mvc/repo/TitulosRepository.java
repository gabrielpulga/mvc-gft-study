package com.gft.mvc.repo;

import com.gft.mvc.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitulosRepository extends JpaRepository<Titulo, Long> {
}
