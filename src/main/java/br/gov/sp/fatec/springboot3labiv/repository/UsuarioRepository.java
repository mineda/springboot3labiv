package br.gov.sp.fatec.springboot3labiv.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3labiv.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findByNome(String nome);

    @Query("select u from Usuario u where u.nome = ?1")
    public Optional<Usuario> buscarPeloNome(String nome);

    public List<Usuario> findByNomeContainsIgnoreCase(String nome);

    @Query("select u from Usuario u where u.nome like %?1%")
    public List<Usuario> buscarPeloNomeParecido(String nome);

    public Optional<Usuario> findByNomeAndSenha(String nome, String senha);

    @Query("select u from Usuario u where u.nome = ?1 and u.senha = ?2")
    public Optional<Usuario> buscarPeloNomeESenha(String nome, String senha);

    public List<Usuario> findByAutorizacoesNome(String nomeAutorizacao);

    @Query("select u from Usuario u join u.autorizacoes a where a.nome = ?1")
    public List<Usuario> buscarPeloNomeAutorizacao(String nomeAutorizacao);
    
}
