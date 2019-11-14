package com.fitsoftware.foodapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fitsoftware.foodapi.domain.repository.PermissaoRepository;
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
public class PermissaoTest {

  private Permissao permissao;

  @Autowired
  private PermissaoRepository permissaoRepository;

  @Test
  @Order(1)
  public void mustFindPermissaoGivenIdTest(){
    Optional<Permissao> permissaoOptional = permissaoRepository.findById(3l);
    assertEquals("Pesquisa Cidade", permissaoOptional.get().getNome());
  }

  @Order(2)
  public void mustGenerateErrorPermissaoNomeIsRequiredTest(){
    Assertions.assertThrows(ConstraintViolationException.class, () -> {
      Permissao noNamePermissao = Permissao.builder().descricao("teste").build();
      permissaoRepository.save(noNamePermissao);
    });
  }

  @Order(3)
  public void mustGenerateErrorPermissaoDescricaoIsRequiredTest(){
    Assertions.assertThrows(ConstraintViolationException.class, () -> {
      Permissao noDescricaoPermissao = Permissao.builder().nome("teste").build();
      permissaoRepository.save(noDescricaoPermissao);
    });
  }

  @Test
  @Order(4)
  public void mustFindAllPermissoesTest(){
    List<Permissao> permissoes = permissaoRepository.findAll();
    assertEquals(3, permissoes.size());
  }

  @Test
  @Order(5)
  public void mustSavePermissaoTest(){
    permissao = Permissao.builder().nome("Testing").descricao("test").build();
    permissao = permissaoRepository.save(permissao);
    assertEquals("Testing", permissao.getNome());
  }

  @Test
  @Order(6)
  public void mustDeletePermissaoByIdTest(){
    permissaoRepository.deleteById(4l);
    List<Permissao> permissoes = permissaoRepository.findAll();
    assertEquals(3, permissoes.size());
  }
}
