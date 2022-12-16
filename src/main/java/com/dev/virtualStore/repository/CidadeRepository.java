package com.dev.virtualStore.repository;

import com.dev.virtualStore.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
