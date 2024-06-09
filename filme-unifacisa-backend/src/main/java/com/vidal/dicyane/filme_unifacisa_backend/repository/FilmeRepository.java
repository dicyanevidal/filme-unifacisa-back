package com.vidal.dicyane.filme_unifacisa_backend.repository;

import com.vidal.dicyane.filme_unifacisa_backend.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
}
