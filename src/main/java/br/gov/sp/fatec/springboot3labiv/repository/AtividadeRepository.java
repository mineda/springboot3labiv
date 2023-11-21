package br.gov.sp.fatec.springboot3labiv.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3labiv.entity.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

    public List<Atividade> findByDataHoraLimiteLessThan(LocalDateTime dataHoraLimite);
    
}
