package br.edu.unifei.bd.bleach;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Mundo implements Serializable{
	private static final long serialVersionUID = 8191916532922401726L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String titulos;
	private int energiaTotal;
	private int quantidadeHabitantes;
	@OneToMany private List<Local> locais = new ArrayList<Local>();
	
	public void caculaEnergiaTotal() {
		energiaTotal = 0;
		for(Local elem: locais) {
			energiaTotal += elem.getConcentracaoEspiritual();
		}
	}
	
	public void calculaQuantidadeHabitantes() {
		quantidadeHabitantes = 0;
		for(Local l : locais) {
			quantidadeHabitantes += l.getHabitantes().size();
		}
	}
	
	public void addLocal(Local local) {
		if(!(local instanceof Fenda)) {
			locais.add(local);
		}
	}
}
