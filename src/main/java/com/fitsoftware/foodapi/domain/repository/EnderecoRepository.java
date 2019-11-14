package com.fitsoftware.foodapi.domain.repository;

import com.fitsoftware.foodapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
