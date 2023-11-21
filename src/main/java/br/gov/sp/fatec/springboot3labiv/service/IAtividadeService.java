package br.gov.sp.fatec.springboot3labiv.service;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.sp.fatec.springboot3labiv.entity.Atividade;

public interface IAtividadeService {

    public List<Atividade> buscarTodas();

    public List<Atividade> buscarTodasAntesLimite(LocalDateTime dataHoraLimite);

    public Atividade novaAtividade(Atividade atividade);
    
}
