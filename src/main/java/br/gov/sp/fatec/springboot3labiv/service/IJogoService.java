package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;

public interface IJogoService {

    public Jogo novoJogo(Jogo jogo);

    public List<Jogo> buscarTodos();

    public List<Jogo> buscarPorEstudioETitulo(String studio, String titulo);
    
}
