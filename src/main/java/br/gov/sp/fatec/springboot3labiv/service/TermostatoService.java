package br.gov.sp.fatec.springboot3labiv.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3labiv.entity.Termostato;
import br.gov.sp.fatec.springboot3labiv.repository.TermostatoRepository;

@Service
public class TermostatoService implements ITermostatoService{

    @Autowired
    private TermostatoRepository termostatoRepo;

    @Override
    public Termostato novaMedida(Termostato termostato) {
        if(termostato == null ||
                termostato.getTemperatura() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(termostato.getDataHora() == null) {
            termostato.setDataHora(LocalDateTime.now());
        }
        return termostatoRepo.save(termostato);
    }

    @Override
    public List<Termostato> buscarTodos() {
        return termostatoRepo.findAll();
    }

    @Override
    public List<Termostato> buscarTodosEntre(LocalDateTime inicio, LocalDateTime fim) {
        return termostatoRepo.findByDataHoraBetween(inicio, fim);
    }
    
}
