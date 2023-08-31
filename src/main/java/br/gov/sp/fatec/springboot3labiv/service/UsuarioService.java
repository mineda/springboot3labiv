package br.gov.sp.fatec.springboot3labiv.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springboot3labiv.entity.Autorizacao;
import br.gov.sp.fatec.springboot3labiv.entity.Usuario;
import br.gov.sp.fatec.springboot3labiv.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springboot3labiv.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autorizacaoRepo;

    @Transactional
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario == null ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() || 
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new IllegalArgumentException("Usuário com atributos inválidos!");
        }
        if(!usuario.getAutorizacoes().isEmpty()) {
            Set<Autorizacao> autorizacoes = new HashSet<Autorizacao>();
            for(Autorizacao autorizacao: usuario.getAutorizacoes()) {
                Autorizacao autorizacaoBd = buscarAutorizacaoPorId(autorizacao.getId());
                autorizacoes.add(autorizacaoBd);
            }
            usuario.setAutorizacoes(autorizacoes);
        }
        
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isEmpty()) {
            throw new IllegalArgumentException("Usuario nao encontrado!");
        }
        return usuarioOp.get();
    }

    public Autorizacao buscarAutorizacaoPorId(Long id) {
        Optional<Autorizacao> autorizacaoOp = autorizacaoRepo.findById(id);
        if(autorizacaoOp.isEmpty()) {
            throw new IllegalArgumentException("Autorizacao nao encontrada!");
        }
        return autorizacaoOp.get();
    }


}
