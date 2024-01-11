package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Cidade extends Local {
	private static final long serialVersionUID = 5535458234538048190L;
	
	private int quantidadePessoas;
	private int tamanho;
	
	public Cidade(String nome, Mundo mundoPertencente) {
		super(mundoPertencente);
		this.setNome(nome);
	}
	
	public void calculaQuantidadePessoas() {
		quantidadePessoas = this.getHabitantes().size();
	}
}
