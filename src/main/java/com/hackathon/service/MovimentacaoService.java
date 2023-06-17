package com.hackathon.service;

import com.hackathon.domain.Correntista;
import com.hackathon.domain.Movimentacao;
import com.hackathon.domain.MovimentacaoTipo;
import com.hackathon.dto.NovaMovimentacao;
import com.hackathon.repository.CorrentistaRepository;
import com.hackathon.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacao novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao();

        //Double valor = novaMovimentacao.getMovimentacaoTipo()== MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        Double valor = novaMovimentacao.getValor();
        if(novaMovimentacao.getMovimentacaoTipo() == MovimentacaoTipo.DESPESA)
            valor = valor * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(movimentacao.getIdConta());
        movimentacao.setMovimentacaoTipo(movimentacao.getMovimentacaoTipo());
        movimentacao.setValor(movimentacao.getValor());

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        movimentacaoRepository.save(movimentacao);
    }

}
