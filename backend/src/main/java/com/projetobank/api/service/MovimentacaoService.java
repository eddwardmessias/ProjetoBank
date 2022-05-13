package com.projetobank.api.service;

import com.projetobank.api.dto.NovaMovimetacao;
import com.projetobank.api.models.Correntista;
import com.projetobank.api.models.Movimentacao;
import com.projetobank.api.models.TipoMovimentacao;
import com.projetobank.api.repository.CorrentistaRepository;
import com.projetobank.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository repository;

    @Autowired
    CorrentistaRepository correntistaRepository;
    public void save(NovaMovimetacao novaMovimetacao){
        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimetacao.getValor();
        if (novaMovimetacao.getTipo() == TipoMovimentacao.DESPESA){
            valor = valor * -1;
        }

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimetacao.getDescricao());
        movimentacao.setTipo(novaMovimetacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimetacao.getIdConta()).orElse(null);
        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao);
    }

}
