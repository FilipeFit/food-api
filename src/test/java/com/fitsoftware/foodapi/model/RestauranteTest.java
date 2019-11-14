package com.fitsoftware.foodapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fitsoftware.foodapi.domain.repository.CozinhaRepository;
import com.fitsoftware.foodapi.domain.repository.EnderecoRepository;
import com.fitsoftware.foodapi.domain.repository.RestauranteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestauranteTest {

  private Restaurante restaurante;

  @Autowired
  private RestauranteRepository restauranteRepository;

  @Autowired
  private CozinhaRepository cozinhaRepository;

  @Autowired
  private EnderecoRepository enderecoRepository;

  @Test
  @Order(1)
  public void mustFindRestauranteGivenIdTest(){
    Optional<Restaurante> restauranteOptional = restauranteRepository.findById(1l);
    assertEquals("Cozinha legal", restauranteOptional.get().getNome());
  }

  @Test
  @Order(2)
  public void mustGenerateErrorRestauranteNomeIsRequiredTest(){
    Assertions.assertThrows(ConstraintViolationException.class, () -> {
      Restaurante noNameRestaurante = Restaurante.builder().build();
      restauranteRepository.save(noNameRestaurante);
    });
  }

  @Test
  @Order(3)
  public void mustFindAllPermissoesTest(){
    List<Restaurante> restaurantes = restauranteRepository.findAll();
    assertEquals(3, restaurantes.size());
  }

  @Test
  @Order(4)
  public void mustSaveRestauranteTest(){
    Optional<Cozinha> cozinhaOptional = cozinhaRepository.findById(1l);
    Optional<Endereco> enderecoOptional = enderecoRepository.findById(1l);

    restaurante = Restaurante.builder()
        .aberto(true)
        .nome("Testing")
        .ativo(true)
        .dataAtualizacao(LocalDate.now())
        .dataCadastro(LocalDate.now())
        .endereco(enderecoOptional.get())
        .cozinha(cozinhaOptional.get())
        .taxa_frete(new BigDecimal("10.50"))
        .build();
    restaurante = restauranteRepository.save(restaurante);
    assertEquals("Testing", restaurante.getNome());
  }

  @Test
  @Order(5)
  public void mustDeleteRestauranteByIdTest(){
    restauranteRepository.deleteById(4l);
    List<Restaurante> restaurantes = restauranteRepository.findAll();
    assertEquals(3, restaurantes.size());
  }
}
