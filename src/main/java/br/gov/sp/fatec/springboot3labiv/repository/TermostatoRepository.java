package br.gov.sp.fatec.springboot3labiv.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3labiv.entity.Termostato;

public interface TermostatoRepository extends JpaRepository<Termostato, Long>{

    public List<Termostato> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
    
}
