package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;

import br.gov.sp.fatec.springboot3labiv.entity.Usuario;

public interface IUsuarioService {

    public Usuario novoUsuario(Usuario usuario);

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarPorId(Long id);
    
}
