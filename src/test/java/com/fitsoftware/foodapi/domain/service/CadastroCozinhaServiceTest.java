package com.fitsoftware.foodapi.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fitsoftware.foodapi.domain.repository.CozinhaRepository;
import com.fitsoftware.foodapi.model.Cozinha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class CadastroCozinhaServiceTest {

  private CadastroCozinhaService cadastroCozinhaService;

  @Mock
  private CozinhaRepository cozinhaRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    cadastroCozinhaService = new CadastroCozinhaService(cozinhaRepository);
  }

  @Test
  public void salvarCozinha() {
    Cozinha cozinha = Cozinha.builder().nome("Testing")
        .id(1l)
        .build();

    Mockito.when(cozinhaRepository.save(cozinha)).thenReturn(cozinha);
    Cozinha cozinhaSalva = cadastroCozinhaService.save(cozinha);
    
    Mockito.verify(cozinhaRepository, Mockito.times(1));
    assertEquals(cozinhaSalva, cozinha);
  }

}