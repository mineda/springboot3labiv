package br.gov.sp.fatec.springboot3labiv.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3labiv.entity.Compromisso;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long>{

    public List<Compromisso> findByNomeContainsAndDataHoraGreaterThan(String nome, LocalDateTime dataHora);
    
}
