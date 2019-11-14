package com.fitsoftware.foodapi.domain.service;

import com.fitsoftware.foodapi.domain.repository.RestauranteRepository;
import com.fitsoftware.foodapi.model.Restaurante;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

  private final RestauranteRepository restauranteRepository;

  public CadastroRestauranteService(
      RestauranteRepository restauranteRepository) {
    this.restauranteRepository = restauranteRepository;
  }

  public Restaurante save(Restaurante restaurante) {
    return restauranteRepository.save(restaurante);

  }


}
