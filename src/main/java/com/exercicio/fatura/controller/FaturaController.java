package com.exercicio.fatura.controller;

import com.exercicio.fatura.model.Fatura;
import com.exercicio.fatura.repository.FaturaRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    private final FaturaRepository faturaRepository;

    public FaturaController(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    @PostMapping
    public ResponseEntity<Fatura> cadastrarFatura(@Valid @RequestBody Fatura fatura) {
        return ResponseEntity.status(HttpStatus.CREATED).body(faturaRepository.save(fatura));
    }

    @GetMapping
    public List<Fatura> listarFaturas() {
        return faturaRepository.findAll();
    }
}
