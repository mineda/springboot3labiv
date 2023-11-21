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

import br.gov.sp.fatec.springboot3labiv.entity.Atividade;
import br.gov.sp.fatec.springboot3labiv.service.IAtividadeService;

@RestController
@RequestMapping(value = "/atividade")
@CrossOrigin
public class AtividadeController {

    @Autowired
    private IAtividadeService service;

    @GetMapping
    public List<Atividade> buscarTodas() {
        return service.buscarTodas();
    }

    @GetMapping(value = "/{limite}")
    public List<Atividade> buscarTodasAntesLimite(@PathVariable("limite") LocalDateTime dataHoraLimite) {
        return service.buscarTodasAntesLimite(dataHoraLimite);
    }

    @PostMapping
    public Atividade novaAtividade(@RequestBody Atividade atividade) {
        return service.novaAtividade(atividade);
    }
    
}
