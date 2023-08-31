package br.gov.sp.fatec.springboot3labiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3labiv.entity.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long>{
    
}
