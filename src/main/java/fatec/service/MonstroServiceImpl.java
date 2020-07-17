package fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fatec.entity.Monstro;
import fatec.entity.Raca;
import fatec.repository.MonstroRepository;
import fatec.repository.RacaRepository;

@Service("monstroService")
public class MonstroServiceImpl implements MonstroService{
    
    @Autowired
	private RacaRepository racaRepo;
	
	@Autowired
	private MonstroRepository monstroRepo;

	@Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Monstro adicionarMonstro(String nomeM, String racaN) {
        Raca raca = racaRepo.findByNome(
				racaN);
		if(raca == null) {
			throw new UsernameNotFoundException(
				"Raça com identificador " +
				racaN +
				" não foi encontrada");
		}
		Monstro monstro = new Monstro();
		monstro.setNome(nomeM);
        monstro.setHp(raca.getHp());
        monstro.setMp(raca.getMp());
        monstro.setAtaque(raca.getAtaque());
        monstro.setDefesa(raca.getDefesa());
        monstro.setAgilidade(raca.getAgilidade());
        monstro.setInteligencia(raca.getInteligencia());
		monstroRepo.save(monstro);
		
		return monstro;
	}
    
}