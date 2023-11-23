package br.gov.sp.fatec.springboot3labiv.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3labiv.entity.Compromisso;
import br.gov.sp.fatec.springboot3labiv.service.ICompromissoService;

@RestController
@RequestMapping(value = "/compromisso")
@CrossOrigin
public class CompromissoController {

    @Autowired
    private ICompromissoService service;

    @PostMapping
    public Compromisso novoCompromisso(@RequestBody Compromisso compromisso) {
        return service.novoCompromisso(compromisso);
    }

    @GetMapping
    public List<Compromisso> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping(value = "/{nome}/{dataHora}")
    public List<Compromisso> buscarPorNomeEDataHora(@PathVariable("nome") String nome, @PathVariable("dataHora") LocalDateTime dataHora) {
        return service.buscarPorNomeEDataHora(nome, dataHora);
    }
    
}
