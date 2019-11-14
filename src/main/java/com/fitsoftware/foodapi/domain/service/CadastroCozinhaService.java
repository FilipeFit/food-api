package com.fitsoftware.foodapi.domain.service;

import com.fitsoftware.foodapi.domain.exception.EntidadeEmUsoException;
import com.fitsoftware.foodapi.domain.repository.CozinhaRepository;
import com.fitsoftware.foodapi.model.Cozinha;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

  private final CozinhaRepository cozinhaRepository;

  public CadastroCozinhaService(
      CozinhaRepository cozinhaRepository) {
    this.cozinhaRepository = cozinhaRepository;
  }

  public Cozinha save(Cozinha cozinha) {
    return cozinhaRepository.save(cozinha);
  }

  public void delete(Long id) {
    try {
      cozinhaRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new EntidadeEmUsoException(
          String.format("Fozinha de código %d não pode ser removida pois está em uso", id));
    }
  }
}
