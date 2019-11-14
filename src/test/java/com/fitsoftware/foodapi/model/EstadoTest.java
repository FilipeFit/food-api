package com.fitsoftware.foodapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fitsoftware.foodapi.domain.repository.EstadoRepository;
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
public class EstadoTest {

  private Estado estado;

  @Autowired
  private EstadoRepository estadoRepository;

  @Test
  @Order(1)
  public void mustFindEstadoGivenIdTest(){
    Optional<Estado> estadoOptional = estadoRepository.findById(3l);
    assertEquals("Bahia", estadoOptional.get().getNome());
  }

  @Test
  @Order(2)
  public void mustGenerateErrorEstadoNameIsRequiredTest(){
    Assertions.assertThrows(ConstraintViolationException.class, () -> {
      Estado noNameEstado = Estado.builder().build();
      estadoRepository.save(noNameEstado);
    });
  }

  @Test
  @Order(3)
  public void mustFindAllEstadosTest(){
    List<Estado> estados = estadoRepository.findAll();
    assertEquals(5, estados.size());
  }

  @Test
  @Order(4)
  public void mustSaveEstadoTest(){
    estado = Estado.builder().nome("Testing").build();
    estado = estadoRepository.save(estado);
    assertEquals("Testing", estado.getNome());
  }

  @Test
  @Order(5)
  public void mustDeleteEstadoByIdTest(){
    estadoRepository.deleteById(6l);
    List<Estado> estados = estadoRepository.findAll();
    assertEquals(5, estados.size());
  }

}

