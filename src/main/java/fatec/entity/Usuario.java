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
@Table(name = "usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_nome", unique = true, length = 20, nullable = false)
    private String nome;

    @Column(name = "usr_email", unique=true, length = 100, nullable = false)
	private String email;

    @Column(name = "usr_senha", length = 100, nullable = false)
    private String senha;

    @Column(name = "usr_raca", length = 40)
    private Raca raca;

    @Column(name = "usr_classe", length = 40)
    private Classe classe;

    @Column(name = "usr_hp", length = 3)
    private int hp = this.raca.getHp() + this.classe.getHp();
    @Column(name = "usr_mp", length = 3)
    private int mp = this.raca.getMp() + this.classe.getMp();
    @Column(name = "usr_ataque", length = 2)
    private int ataque = this.raca.getAtaque() + this.classe.getAtaque();
    @Column(name = "usr_defesa", length = 2)
    private int defesa = this.raca.getDefesa() + this.classe.getDefesa();
    @Column(name = "usr_agilidade", length = 2)
    private int agilidade = this.raca.getAgilidade() + this.classe.getAgilidade();
    @Column(name = "usr_inteligencia", length = 2)
    private int inteligencia = this.raca.getInteligencia() + this.classe.getInteligencia();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "uau_usuario_autorizacao",
        joinColumns = { @JoinColumn(name = "usr_id") },
        inverseJoinColumns = {@JoinColumn(name = "aut_id") })
    private Set<Autorizacao> autorizacoes;

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

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
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

    public String getRaca() {
        return raca.getNome();
    }

    public void setRaca(String raca) {
        this.raca.setNome(raca);
    }

}