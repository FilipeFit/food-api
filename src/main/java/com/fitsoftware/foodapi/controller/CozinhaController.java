package com.fitsoftware.foodapi.controller;

import com.fitsoftware.foodapi.domain.service.CadastroCozinhaService;
import com.fitsoftware.foodapi.model.Cozinha;
import com.fitsoftware.foodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

  private final CozinhaRepository cozinhaRepository;
  private final CadastroCozinhaService cadastroCozinhaService;

  public CozinhaController(
      CozinhaRepository cozinhaRepository,
      CadastroCozinhaService cadastroCozinhaService) {
    this.cozinhaRepository = cozinhaRepository;
    this.cadastroCozinhaService = cadastroCozinhaService;
  }

  @GetMapping
  public List<Cozinha> findAll() {
    return cozinhaRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cozinha> findById(@PathVariable Long id) {
    Optional<Cozinha> cozinhaOptional = cozinhaRepository.findById(id);
    return cozinhaOptional.isPresent() ? ResponseEntity.ok(cozinhaOptional.get())
        : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity save(@RequestBody Cozinha cozinha) {
    Cozinha cozinhaSalva = cadastroCozinhaService.save(cozinha);
    return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaSalva);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody Cozinha cozinha) {

    Optional<Cozinha> savedCozinhaOptional = cozinhaRepository.findById(id);
    if (savedCozinhaOptional.isPresent()) {
      Cozinha savedCozinha = savedCozinhaOptional.get();

      BeanUtils.copyProperties(cozinha, savedCozinha, "id");
      cozinhaRepository.save(savedCozinha);
      return ResponseEntity.ok(savedCozinha);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Cozinha> delete(@PathVariable Long id) {
    Optional<Cozinha> savedCozinhaOptional = cozinhaRepository.findById(id);
    if (savedCozinhaOptional.isPresent()) {
      cadastroCozinhaService.delete(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
