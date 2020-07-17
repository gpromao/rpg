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

import fatec.entity.Classe;
import fatec.repository.ClasseRepository;
import fatec.service.ClasseService;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/classe")
@CrossOrigin

public class ClasseController {
    
    @Autowired
    private ClasseService classeService; 
    @Autowired
    private ClasseRepository classeRepo;
    
    @PostMapping(value = "/nova")
    @JsonView(View.ClasseCompleta.class)
    public Classe cadastrarClasse(@RequestBody ClasseDTO classe) {
        return classeService.adicionarClasse(classe.getNome(), 
                classe.getHp(),
                classe.getMp(),
                classe.getAtaque(),
                classe.getDefesa(),
                classe.getAgilidade(),
                classe.getInteligencia());
    }
    
    @GetMapping(value = "/busca/{nome}")
    @JsonView(View.ClasseCompleta.class)
    public List<Classe> buscarPorNome(
    		@PathVariable("nome") String nome) {
    	return classeRepo.findByNome(nome);
    }

}