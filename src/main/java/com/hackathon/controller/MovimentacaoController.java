package com.hackathon.controller;


import com.hackathon.domain.Movimentacao;
import com.hackathon.dto.NovaMovimentacao;
import com.hackathon.repository.MovimentacaoRepository;
import com.hackathon.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Movimentacao> findAll(){
        return movimentacaoRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao novaMovimentacao){
        movimentacaoService.save(novaMovimentacao);
    }

}
