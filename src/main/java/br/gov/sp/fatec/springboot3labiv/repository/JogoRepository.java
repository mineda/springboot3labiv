package br.gov.sp.fatec.springboot3labiv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

    public List<Jogo> findByEstudioAndTituloContains(String estudio, String titulo);
    
}
