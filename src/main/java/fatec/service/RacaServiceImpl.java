package fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fatec.entity.Raca;
import fatec.entity.Usuario;
import fatec.repository.RacaRepository;
import fatec.repository.UsuarioRepository;

@Service("racaService")
public class RacaServiceImpl implements RacaService{

    @Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private RacaRepository racaRepo;

	@Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Raca adicionarRaca(String nome, int hp, int mp, int ataque, int defesa, int agilidade, int inteligencia) {
		Usuario usuario = usuarioRepo.findTop1ByNome(
				nome);
		if(usuario == null) {
			throw new UsernameNotFoundException(
				"Usuário com identificador " +
				nome +
				" não foi encontrado");
		}
		Raca raca = new Raca();
		raca.setNome(nome);
        raca.setHp(hp);
        raca.setMp(mp);
        raca.setAtaque(ataque);
        raca.setDefesa(defesa);
        raca.setAgilidade(agilidade);
        raca.setInteligencia(inteligencia);
		racaRepo.save(raca);
		
		return raca;
	}
    
}