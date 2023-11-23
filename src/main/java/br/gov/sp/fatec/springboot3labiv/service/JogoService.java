package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;
import br.gov.sp.fatec.springboot3labiv.repository.JogoRepository;

@Service
public class JogoService implements IJogoService{

    @Autowired
    private JogoRepository jogoRepo;

    @Override
    public Jogo novoJogo(Jogo jogo) {
        if(jogo == null ||
                jogo.getTitulo() == null ||
                jogo.getEstudio() == null ||
                jogo.getDataHoraLancamento() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        return jogoRepo.save(jogo);
    }

    @Override
    public List<Jogo> buscarTodos() {
        return jogoRepo.findAll();
    }

    @Override
    public List<Jogo> buscarPorEstudioETitulo(String studio, String titulo) {
        return jogoRepo.findByEstudioAndTituloContains(studio, titulo);
    }
    
}
