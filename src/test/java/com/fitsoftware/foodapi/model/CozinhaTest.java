package com.fitsoftware.foodapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fitsoftware.foodapi.domain.repository.CozinhaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CozinhaTest {

  private Cozinha cozinha;

  @Autowired
  private CozinhaRepository cozinhaRepository;

  @Test
  @Order(1)
  public void mustFindCozinhaGivenIdTest() {
    Optional<Cozinha> cozinhaOptional = cozinhaRepository.findById(3l);
    assertEquals("Brasileira", cozinhaOptional.get().getNome());
  }

  @Order(2)
  public void mustGenerateErrorCozinhaNameIsRequiredTest() {
    Assertions.assertThrows(ConstraintViolationException.class, () -> {
      Cozinha noNamecozinha = Cozinha.builder().build();
      cozinhaRepository.save(noNamecozinha);
    });
  }

  @Test
  @Order(3)
  public void mustFindAllCozinhasTest() {
    List<Cozinha> cozinhas = cozinhaRepository.findAll();
    assertEquals(3, cozinhas.size());
  }

  @Test
  @Order(4)
  public void mustSaveEstadoTest() {
    cozinha = Cozinha.builder().nome("Testing").build();
    cozinha = cozinhaRepository.save(cozinha);
    assertEquals("Testing", cozinha.getNome());
  }

  @Test
  @Order(5)
  public void mustDeleteEstadoByIdTest() {
    cozinhaRepository.deleteById(4l);
    List<Cozinha> cozinhas = cozinhaRepository.findAll();
    assertEquals(3, cozinhas.size());
  }

}
