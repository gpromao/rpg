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
@Table(name = "cls_classe")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cls_id")
    @JsonView(View.ClasseCompleta.class)
    private Long id;

    @Column(name = "cls_nome", unique = true, length = 20, nullable = false)
    @JsonView(View.ClasseResumo.class)
    private String nome;

    @Column(name = "cls_hp", length = 3, nullable = false)
    @JsonView(View.ClasseResumo.class)
    private int hp;
    @Column(name = "cls_mp", length = 3, nullable = false)
    @JsonView(View.ClasseResumo.class)
    private int mp;
    @Column(name = "cls_ataque", length = 2, nullable = false)
    @JsonView(View.ClasseResumo.class)
    private int ataque;
    @Column(name = "cls_defesa", length = 2, nullable = false)
    @JsonView(View.ClasseResumo.class)
    private int defesa;
    @Column(name = "cls_agilidade", length = 2, nullable = false)
    @JsonView(View.ClasseResumo.class)
    private int agilidade;
    @Column(name = "cls_inteligencia", length = 2, nullable = false)
    @JsonView(View.ClasseResumo.class)
    private int inteligencia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
    private Set<Classe> classes;

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