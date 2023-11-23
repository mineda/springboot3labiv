package br.gov.sp.fatec.springboot3labiv.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3labiv.entity.Compromisso;
import br.gov.sp.fatec.springboot3labiv.repository.CompromissoRepository;

@Service
public class CompromissoService implements ICompromissoService{

    @Autowired
    private CompromissoRepository compromissoRepo;

    @Override
    public Compromisso novoCompromisso(Compromisso compromisso) {
        if(compromisso == null ||
                compromisso.getNome() == null ||
                compromisso.getDuracaoPrevista() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(compromisso.getDataHora() == null) {
            compromisso.setDataHora(LocalDateTime.now());
        }
        return compromissoRepo.save(compromisso);
    }

    @Override
    public List<Compromisso> buscarTodos() {
        return compromissoRepo.findAll();
    }

    @Override
    public List<Compromisso> buscarPorNomeEDataHora(String nome, LocalDateTime dataHora) {
        return compromissoRepo.findByNomeContainsAndDataHoraGreaterThan(nome, dataHora);
    }
    
}
