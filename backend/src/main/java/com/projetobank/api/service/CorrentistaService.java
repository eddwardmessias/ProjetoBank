package com.projetobank.api.service;

import com.projetobank.api.dto.NovoCorrentista;
import com.projetobank.api.models.Conta;
import com.projetobank.api.models.Correntista;
import com.projetobank.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CorrentistaService {

    @Autowired
    private CorrentistaRepository repository;

    public void save (NovoCorrentista novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setNome(novoCorrentista.getNome());
        correntista.setCpf(novoCorrentista.getCpf());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());
        correntista.setConta(conta);

        repository.save(correntista);


    }
}
