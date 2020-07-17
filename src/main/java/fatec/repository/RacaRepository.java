package fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import fatec.entity.Raca;

public interface RacaRepository extends JpaRepository<Raca, Long>{

    @PreAuthorize("isAuthenticated()")
    public List<Raca> findTop1ByNome(String nome);

    public Raca findByNome(String nome);
    
}