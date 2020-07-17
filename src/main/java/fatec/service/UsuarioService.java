package fatec.service;

import fatec.entity.Usuario;

public interface UsuarioService {

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);

}