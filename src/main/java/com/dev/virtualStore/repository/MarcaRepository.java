package com.dev.virtualStore.repository;

import com.dev.virtualStore.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
