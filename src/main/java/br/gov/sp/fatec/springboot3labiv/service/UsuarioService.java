package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3labiv.entity.Usuario;
import br.gov.sp.fatec.springboot3labiv.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    public Usuario novoUsuario(Usuario usuario) {
        if(usuario == null ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() || 
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new IllegalArgumentException("Usuário com atributos inválidos!");
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


}
