package com.fitsoftware.foodapi.repository;

import com.fitsoftware.foodapi.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

  Optional<Estado> findByNome(String nome);
}
