package com.projetobank.api.controller;

import com.projetobank.api.dto.NovoCorrentista;
import com.projetobank.api.models.Correntista;
import com.projetobank.api.repository.CorrentistaRepository;
import com.projetobank.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;

    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){

        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista novoCorrentista){

        service.save(novoCorrentista);
    }

}
