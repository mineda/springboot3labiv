package br.gov.sp.fatec.springboot3labiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3labiv.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
