package com.fitsoftware.foodapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fitsoftware.foodapi.domain.repository.CidadeRepository;
import com.fitsoftware.foodapi.domain.repository.EnderecoRepository;
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
public class EnderecoTest {

  private Endereco endereco;

  @Autowired
  private EnderecoRepository enderecoRepository;

  @Autowired
  private CidadeRepository cidadeRepository;

  @Test
  @Order(1)
  public void mustFindEnderecoGivenIdTest() {
    Optional<Endereco> enderecoOptional = enderecoRepository.findById(1l);
    assertEquals("13466110", enderecoOptional.get().getCep());
  }

  @Test
  @Order(2)
  public void mustGenerateErrorEnderecoCepIsRequiredTest() {
    Assertions.assertThrows(ConstraintViolationException.class, () -> {
      Endereco noCepEndereco = Endereco.builder().build();
      enderecoRepository.save(noCepEndereco);
    });
  }

  @Test
  @Order(3)
  public void mustFindAllEnderecosTest() {
    List<Endereco> enderecos = enderecoRepository.findAll();
    assertEquals(3, enderecos.size());
  }

  @Test
  @Order(4)
  public void mustSaveEnderecoTest() {
    Optional<Cidade> cidadeOptional = cidadeRepository.findById(1l);
    endereco = Endereco.builder()
        .cep("123456789")
        .bairro("testing")
        .logradouro("testing")
        .cidade(cidadeOptional.get())
        .numero("21")
        .build();
    endereco = enderecoRepository.save(endereco);
    assertEquals("123456789", endereco.getCep());
  }

  @Test
  @Order(5)
  public void mustDeleteEnderecoByIdTest() {
    enderecoRepository.deleteById(4l);
    List<Endereco> enderecos = enderecoRepository.findAll();
    assertEquals(3, enderecos.size());
  }

}
