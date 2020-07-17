package fatec;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import fatec.entity.Classe;
import fatec.repository.ClasseRepository;
import fatec.service.ClasseService;

import fatec.entity.Raca;
import fatec.repository.RacaRepository;
import fatec.service.RacaService;

import fatec.entity.Usuario;
import fatec.repository.UsuarioRepository;
import fatec.service.UsuarioService;

import fatec.entity.Monstro;
import fatec.repository.MonstroRepository;
import fatec.service.MonstroService;

@SpringBootTest
@Transactional
@Rollback

public class RpgApplicationTests {

    @Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ClasseRepository classeRepo;
	@Autowired
	private ClasseService classeService;

	@Autowired
	private RacaRepository racaRepo;
	@Autowired
	private RacaService racaService;

	@Autowired
	private MonstroRepository monstroRepo;
	@Autowired
	private MonstroService monstroService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void usuarioRepositorySaveTest() {
		Usuario usuario = new Usuario();
		usuario.setNome("Teste");
		usuario.setEmail("Teste@teste");
		usuario.setSenha("Senha");
		
		usuarioRepo.save(usuario);
		
		assertNotNull(usuario.getId());
	}
	
	@Test
	void fraseRepositorySaveTest() {
		Usuario usuario = new Usuario();
		usuario.setNome("Teste");
		usuario.setEmail("Teste@teste");
		usuario.setSenha("Senha");
		
		usuarioRepo.save(usuario);

	}
	
	@Test
	void usuarioServiceNovoUsuarioTest() {
		Usuario usuario = usuarioService.novoUsuario(
				"Teste",
				"Teste@teste",
				"Senha", 
				"ROLE_ADMIN");		
		assertNotNull(usuario.getId());
	}
	
    @Test
	void fraseServiceAdicionarClasseTest() {
		usuarioService.novoUsuario(
				"Teste",
				"Teste@teste",
				"Senha", 
				"ROLE_ADMIN");
		Classe classe = classeService.adicionarClasse( 
				"Teste", 
				100,100,10,10,10,10);
		assertNotNull(classe.getId());
	}

	@Test
	void fraseServiceAdicionarRacaTest() {
		usuarioService.novoUsuario(
				"Teste",
				"Teste@teste",
				"Senha", 
				"ROLE_ADMIN");
		Raca raca = racaService.adicionarRaca( 
				"Teste", 
				100,100,10,10,10,10);
		assertNotNull(raca.getId());
	}

	@Test
	void fraseServiceAdicionarMonstroTest() {
		usuarioService.novoUsuario(
				"Teste",
				"Teste@teste",
				"Senha", 
				"ROLE_ADMIN");
		Monstro monstro = monstroService.adicionarMonstro( 
				"Teste", 
				"Teste");
		assertNotNull(monstro.getId());
	}

}