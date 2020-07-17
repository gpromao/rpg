package fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import fatec.entity.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long>{
	
	@PreAuthorize("isAuthenticated()")
    public List<Classe> findByNome(String nome);

}
