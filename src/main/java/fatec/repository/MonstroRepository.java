package fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import fatec.entity.Monstro;

public interface MonstroRepository extends JpaRepository<Monstro, Long>{

    @PreAuthorize("isAuthenticated()")
    public List<Monstro> findByNome(String nome);
    
}