package fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fatec.entity.Classe;
import fatec.entity.Usuario;
import fatec.repository.ClasseRepository;
import fatec.repository.UsuarioRepository;

@Service("classeService")
public class ClasseServiceImpl implements ClasseService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private ClasseRepository classeRepo;

	@Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Classe adicionarClasse(String nome, int hp, int mp, int ataque, int defesa, int agilidade, int inteligencia) {
		Usuario usuario = usuarioRepo.findTop1ByNome(
				nome);
		if(usuario == null) {
			throw new UsernameNotFoundException(
				"Usuário com identificador " +
				nome +
				" não foi encontrado");
		}
		Classe classe = new Classe();
		classe.setNome(nome);
        classe.setHp(hp);
        classe.setMp(mp);
        classe.setAtaque(ataque);
        classe.setDefesa(defesa);
        classe.setAgilidade(agilidade);
        classe.setInteligencia(inteligencia);
		classeRepo.save(classe);
		
		return classe;
	}

}
