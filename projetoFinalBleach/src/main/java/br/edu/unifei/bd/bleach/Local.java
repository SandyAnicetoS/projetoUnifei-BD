package br.edu.unifei.bd.bleach;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public abstract class Local implements Serializable{
	private static final long serialVersionUID = 7455593558926839523L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	private int concentracaoEspiritual;
	@OneToMany private List<Ser> habitantes = new ArrayList<Ser>();
	@ManyToOne private Mundo mundoPertencente;
	
	
	public Local(Mundo mundoPertencente) {
		this.mundoPertencente = mundoPertencente;
	}
	private void calculaConcentracao() {
		concentracaoEspiritual = 0;
		for(Ser elem : habitantes) {
			concentracaoEspiritual += elem.getReiatsu();
		}
	}
	
	
	public int getConcentracaoEspiritual() {
		calculaConcentracao();
		return concentracaoEspiritual;
	}
}
