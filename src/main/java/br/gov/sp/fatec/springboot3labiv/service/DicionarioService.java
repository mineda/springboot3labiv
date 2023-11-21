package br.gov.sp.fatec.springboot3labiv.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3labiv.entity.Dicionario;
import br.gov.sp.fatec.springboot3labiv.repository.DicionarioRepository;

@Service
public class DicionarioService implements IDicionarioService{

    @Autowired
    private DicionarioRepository dicionarioRepo;

    @Override
    public List<Dicionario> buscarTodos() {
        return dicionarioRepo.findAll();
    }

    @Override
    public List<Dicionario> buscarPeloVerbete(String verbete) {
        return dicionarioRepo.findByVerbeteContainsIgnoreCase(verbete);
    }

    @Override
    public Dicionario novoDicionario(Dicionario dicionario) {
        if(dicionario == null ||
                dicionario.getVerbete() == null ||
                dicionario.getSignificado() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(dicionario.getDataHoraCadastro() == null) {
            dicionario.setDataHoraCadastro(LocalDateTime.now());
        }
        return dicionarioRepo.save(dicionario);
    }
    
}
