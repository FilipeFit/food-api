package com.fitsoftware.foodapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fitsoftware.foodapi.domain.repository.FormaPagamentoRepository;
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
public class FormaPagamentoTest {

  private FormaPagamento formaPagamento;

  @Autowired
  private FormaPagamentoRepository formaPagamentoRepository;

  @Test
  @Order(1)
  public void mustFindFormaPagamentoGivenIdTest(){
    Optional<FormaPagamento> formaPagamentoOptional = formaPagamentoRepository.findById(3l);
    assertEquals("Cartão de débito", formaPagamentoOptional.get().getDescricao());
  }

  @Order(2)
  public void mustGenerateErrorFormaPagamentoDescricaoIsRequiredTest(){
    Assertions.assertThrows(ConstraintViolationException.class, () -> {
      FormaPagamento noDescricaoFormaPagamento = FormaPagamento.builder().build();
      formaPagamentoRepository.save(noDescricaoFormaPagamento);
    });
  }

  @Test
  @Order(3)
  public void mustFindAllFormasPagamentoTest(){
    List<FormaPagamento> formasPagamento = formaPagamentoRepository.findAll();
    assertEquals(3, formasPagamento.size());
  }

  @Test
  @Order(4)
  public void mustSaveFormaPagamentoTest(){
    formaPagamento = FormaPagamento.builder().descricao("Testing").build();
    formaPagamento = formaPagamentoRepository.save(formaPagamento);
    assertEquals("Testing", formaPagamento.getDescricao());
  }

  @Test
  @Order(5)
  public void mustDeleteFormaPagamentoByIdTest(){
    formaPagamentoRepository.deleteById(4l);
    List<FormaPagamento> formasPagamentos = formaPagamentoRepository.findAll();
    assertEquals(3, formasPagamentos.size());
  }
}
