package br.edu.unifei.bd.bleach;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Ser implements Serializable{
	private static final long serialVersionUID = 1275110043657408357L;
	
	@Id
	private String nome;
	private int reiatsu;
	private boolean morto = false;
	@ManyToOne private Organizacao organizacao;
	@OneToOne private Raca raca;
	@ManyToOne private Local localAtual;
	@OneToOne private Armamento espada;
	@OneToMany private List<Habilidade> habilidades = new ArrayList<Habilidade>();
	
	public Ser(Raca raca) {
		this.raca = raca;
	}
	
	public void transformar(Raca novaRaca) {
		raca.transformacao(this, novaRaca);
	}
}
