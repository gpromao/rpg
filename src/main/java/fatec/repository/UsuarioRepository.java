package fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findTop1ByNome(String nome);

}
