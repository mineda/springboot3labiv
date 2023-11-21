package br.gov.sp.fatec.springboot3labiv.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3labiv.entity.Atividade;
import br.gov.sp.fatec.springboot3labiv.repository.AtividadeRepository;

@Service
public class AtividadeService implements IAtividadeService{

    @Autowired
    private AtividadeRepository atividadeRepo;

    @Override
    public List<Atividade> buscarTodas() {
        return atividadeRepo.findAll();
    }

    @Override
    public List<Atividade> buscarTodasAntesLimite(LocalDateTime dataHoraLimite) {
        return atividadeRepo.findByDataHoraLimiteLessThan(dataHoraLimite);
    }

    @Override
    public Atividade novaAtividade(Atividade atividade) {
        if(atividade == null ||
                atividade.getEnunciado() == null ||
                atividade.getDataHoraLimite() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }
        if(atividade.getDataHoraCadastro() == null) {
            atividade.setDataHoraCadastro(LocalDateTime.now());
        }
        return atividadeRepo.save(atividade);
    }
    
}
