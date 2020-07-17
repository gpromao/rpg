package fatec.service;

import fatec.entity.Raca;

public interface RacaService {

    public Raca adicionarRaca(String nome, int hp, int mp, int ataque, int defesa, int agilidade, int inteligencia);

    
}