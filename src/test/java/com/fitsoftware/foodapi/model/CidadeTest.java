package com.fitsoftware.foodapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fitsoftware.foodapi.domain.repository.CidadeRepository;
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
public class CidadeTest {

  private Cidade cidade;

  @Autowired
  private CidadeRepository cidadeRepository;

  @Autowired
  private EstadoRepository estadoRepository;

  @Test
  @Order(1)
  public void mustFindCidadeGivenIdTest(){
    Optional<Cidade> cidadeOptional = cidadeRepository.findById(3l);
    assertEquals("São Paulo", cidadeOptional.get().getNome());
  }

  @Order(2)
  public void mustGenerateErrorCidadeNameIsRequiredTest(){
    Assertions.assertThrows(ConstraintViolationException.class, () -> {
      Cidade noNameCidade = Cidade.builder().build();
      cidadeRepository.save(noNameCidade);
    });
  }

  @Test
  @Order(3)
  public void mustFindAllCidadesTest(){
    List<Cidade> cidades = cidadeRepository.findAll();
    assertEquals(5, cidades.size());
  }

  @Test
  @Order(4)
  public void mustSaveCidadeTest(){
    Optional<Estado> estadoOptional = estadoRepository.findById(1l);
    cidade = Cidade.builder().nome("Testing").estado(estadoOptional.get()).build();
    cidade = cidadeRepository.save(cidade);
    assertEquals("Testing", cidade.getNome());
  }

  @Test
  @Order(5)
  public void mustDeleteCidadeByIdTest(){
    cidadeRepository.deleteById(6l);
    List<Cidade> cidades = cidadeRepository.findAll();
    assertEquals(5, cidades.size());
  }




}
