package com.projetobank.api.controller;

import com.projetobank.api.dto.NovaMovimetacao;
import com.projetobank.api.dto.NovoCorrentista;
import com.projetobank.api.models.Correntista;
import com.projetobank.api.models.Movimentacao;
import com.projetobank.api.repository.CorrentistaRepository;
import com.projetobank.api.repository.MovimentacaoRepository;
import com.projetobank.api.service.CorrentistaService;
import com.projetobank.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){

        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimetacao novaMovimetacao){

        service.save(novaMovimetacao);
    }

}
