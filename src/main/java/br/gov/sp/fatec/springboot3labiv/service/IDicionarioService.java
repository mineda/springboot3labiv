package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;

import br.gov.sp.fatec.springboot3labiv.entity.Dicionario;

public interface IDicionarioService {

    public List<Dicionario> buscarTodos();

    public List<Dicionario> buscarPeloVerbete(String verbete);

    public Dicionario novoDicionario(Dicionario dicionario);
    
}
