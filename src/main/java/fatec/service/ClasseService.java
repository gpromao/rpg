package fatec.service;

import fatec.entity.Classe;

public interface ClasseService {
    
    public Classe adicionarClasse(String nome, int hp, int mp, int ataque, int defesa, int agilidade, int inteligencia);

}