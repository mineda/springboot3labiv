package br.gov.sp.fatec.springboot3labiv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3labiv.entity.Dicionario;

public interface DicionarioRepository extends JpaRepository<Dicionario, Long>{

    public List<Dicionario> findByVerbeteContainsIgnoreCase(String verbete);
    
}
