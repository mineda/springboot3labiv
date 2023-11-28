package br.gov.sp.fatec.springboot3labiv.service;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.sp.fatec.springboot3labiv.entity.Termostato;

public interface ITermostatoService {

    public Termostato novaMedida(Termostato termostato);

    public List<Termostato> buscarTodos();

    public List<Termostato> buscarTodosEntre(LocalDateTime inicio, LocalDateTime fim);
    
}
