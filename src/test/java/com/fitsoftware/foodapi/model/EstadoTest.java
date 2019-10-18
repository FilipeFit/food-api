package com.fitsoftware.foodapi.model;

import static org.junit.Assert.assertEquals;

import com.fitsoftware.foodapi.repository.EstadoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoTest {

  private Estado estado;

  @Autowired
  private EstadoRepository estadoRepository;


  @Before
  public void setUp(){
    estado = Estado.builder().nome("Testing").build();
    estado = estadoRepository.save(estado);
  }

  @Test
  public void mustSaveEstadoTest(){
    assertEquals("Testing", estado.getNome());
  }

  @Test
  public void mustFindEstadoGivenName(){
    Optional<Estado> estadoOptional = estadoRepository.findById(estado.getId());
    assertEquals(estadoOptional.get().getNome(),estado.getNome());
  }

  @Test(expected = ConstraintViolationException.class)
  public void mustGenerateErrorEstadoIsRequired(){
    Estado noNameEstado = Estado.builder().build();
    estadoRepository.save(noNameEstado);
  }

  @Test
  public void mustFindEstadoByName(){
    Estado queryEstado = Estado.builder().nome("queryName").build();
    estadoRepository.save(queryEstado);
    Optional<Estado> estadoOptional = estadoRepository.findByNome("queryName");
    assertEquals(estadoOptional.get().getNome(),queryEstado.getNome());
  }
}
