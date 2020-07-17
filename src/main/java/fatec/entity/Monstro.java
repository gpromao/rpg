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

@Entity
@Table(name = "mon_monstro")
public class Monstro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mon_id")
    private Long id;

    @Column(name = "mon_nome", unique = true, length = 20, nullable = false)
    private String nome;

    @Column(name = "mon_raca", length = 40, nullable = false)
    private String raca;

    @Column(name = "mon_hp", length = 3)
    private int hp;
    @Column(name = "mon_mp", length = 3)
    private int mp;
    @Column(name = "mon_ataque", length = 2)
    private int ataque;
    @Column(name = "mon_defesa", length = 2)
    private int defesa;
    @Column(name = "mon_agilidade", length = 2)
    private int agilidade;
    @Column(name = "mon_inteligencia", length = 2)
    private int inteligencia;


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

    public String getRaca() {
        return this.getNome();
    }

    public void setRaca(String raca) {
        this.setNome(raca);
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