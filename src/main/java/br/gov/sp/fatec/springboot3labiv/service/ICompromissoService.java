package br.gov.sp.fatec.springboot3labiv.service;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.sp.fatec.springboot3labiv.entity.Compromisso;

public interface ICompromissoService {

    public Compromisso novoCompromisso(Compromisso compromisso);

    public List<Compromisso> buscarTodos();

    public List<Compromisso> buscarPorNomeEDataHora(String nome, LocalDateTime dataHora);
    
}
