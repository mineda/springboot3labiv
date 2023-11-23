package br.gov.sp.fatec.springboot3labiv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;
import br.gov.sp.fatec.springboot3labiv.service.IJogoService;

@RestController
@RequestMapping(value = "/jogo")
@CrossOrigin
public class JogoController {

    @Autowired
    private IJogoService service;

    @PostMapping
    public Jogo novoJogo(@RequestBody Jogo jogo) {
        return service.novoJogo(jogo);
    }

    @GetMapping
    public List<Jogo> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping(value = "/{estudio}/{titulo}")
    public List<Jogo> buscarPorEstudioETitulo(@PathVariable("estudio") String estudio, @PathVariable("titulo") String titulo) {
        return service.buscarPorEstudioETitulo(estudio, titulo);
    }
    
}
