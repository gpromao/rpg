package fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.entity.Raca;
import fatec.repository.RacaRepository;
import fatec.service.RacaService;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/raca")
@CrossOrigin

public class RacaController {

    @Autowired
    private RacaService racaService;
    
    @Autowired
    private RacaRepository racaRepo;
    
    @PostMapping(value = "/nova")
    @JsonView(View.RacaCompleta.class)
    public Raca cadastrarRaca(@RequestBody RacaDTO raca) {
        return racaService.adicionarRaca(raca.getNome(), 
                raca.getHp(),
                raca.getMp(),
                raca.getAtaque(),
                raca.getDefesa(),
                raca.getAgilidade(),
                raca.getInteligencia());
    }
    
    @GetMapping(value = "/busca/{nome}")
    @JsonView(View.RacaCompleta.class)
    public List<Raca> buscarPorNome(
    		@PathVariable("nome") String nome) {
    	return racaRepo.findTop1ByNome(nome);
    }
    
}