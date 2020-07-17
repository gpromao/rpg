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

import fatec.entity.Monstro;
import fatec.repository.MonstroRepository;
import fatec.service.MonstroService;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/monstro")
@CrossOrigin

public class MonstroController {

    @Autowired
    private MonstroService monstroService;
    @Autowired
    private MonstroRepository monstroRepo;

    @PostMapping(value = "/novo")
    @JsonView(View.MonstroCompleta.class)
    public Monstro cadastrarMonstro(@RequestBody MonstroDTO monstro) {
        return monstroService.adicionarMonstro(monstro.getNome(),
                monstro.getRaca());
    }
    
    @GetMapping(value = "/busca/{nome}")
    @JsonView(View.MonstroCompleta.class)
    public List<Monstro> buscarPorNome(
    		@PathVariable("nome") String nome) {
    	return monstroRepo.findByNome(nome);
    }
    
}