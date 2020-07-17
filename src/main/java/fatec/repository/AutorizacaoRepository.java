package fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNome(String nome);

}
