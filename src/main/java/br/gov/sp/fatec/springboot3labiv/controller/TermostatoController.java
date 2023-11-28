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

import br.gov.sp.fatec.springboot3labiv.entity.Termostato;
import br.gov.sp.fatec.springboot3labiv.service.ITermostatoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/termostato")
public class TermostatoController {

    @Autowired
    private ITermostatoService service;

    @GetMapping
    public List<Termostato> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    public Termostato novaMedida(@RequestBody Termostato termostato) {
        return service.novaMedida(termostato);
    }

    @GetMapping(value = "/{inicio}/{fim}")
    public List<Termostato> buscarTodosEntre(@PathVariable("inicio") LocalDateTime inicio, @PathVariable("fim") LocalDateTime fim) {
        return service.buscarTodosEntre(inicio, fim);
    }
    
}
