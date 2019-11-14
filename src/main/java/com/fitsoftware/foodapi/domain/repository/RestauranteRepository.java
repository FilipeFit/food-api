package com.fitsoftware.foodapi.domain.repository;

import com.fitsoftware.foodapi.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
