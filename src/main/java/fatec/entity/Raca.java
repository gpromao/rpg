package fatec.entity;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonView;

import fatec.controller.View;

@Entity
@Table(name = "rac_raca")
public class Raca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rac_id")
	@JsonView(View.RacaCompleta.class)
    private Long id;

    @Column(name = "rac_nome", unique = true, length = 20, nullable = false)
    @JsonView(View.RacaResumo.class)
    private String nome;

    @Column(name = "rac_hp", length = 3, nullable = false)
    @JsonView(View.RacaResumo.class)
    private int hp;
    @Column(name = "rac_mp", length = 3, nullable = false)
    @JsonView(View.RacaResumo.class)
    private int mp;
    @Column(name = "rac_ataque", length = 2, nullable = false)
    @JsonView(View.RacaResumo.class)
    private int ataque;
    @Column(name = "rac_defesa", length = 2, nullable = false)
    @JsonView(View.RacaResumo.class)
    private int defesa;
    @Column(name = "rac_agilidade", length = 2, nullable = false)
    @JsonView(View.RacaResumo.class)
    private int agilidade;
    @Column(name = "rac_inteligencia", length = 2, nullable = false)
    @JsonView(View.RacaResumo.class)
    private int inteligencia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "raca")
    private Set<Raca> racas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

}