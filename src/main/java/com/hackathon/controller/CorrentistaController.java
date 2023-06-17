package com.hackathon.controller;

import com.hackathon.domain.Correntista;
import com.hackathon.dto.NovoCorrentista;
import com.hackathon.repository.CorrentistaRepository;
import com.hackathon.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private CorrentistaService correntistaService;

    @GetMapping
    public List<Correntista> findAll(){
    return correntistaRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista){
        correntistaService.save(correntista);
    }

}
