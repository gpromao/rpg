package fatec.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fatec.entity.Autorizacao;
import fatec.entity.Usuario;
import fatec.repository.AutorizacaoRepository;
import fatec.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private AutorizacaoRepository autorizacaoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    @Transactional
    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao) {
        Autorizacao aut = autorizacaoRepo.findByNome(autorizacao);

        if (aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);

        usuarioRepo.save(usuario);

        return usuario;
    }

}
