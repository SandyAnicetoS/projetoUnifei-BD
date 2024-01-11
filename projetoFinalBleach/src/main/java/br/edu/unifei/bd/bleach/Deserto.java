package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Deserto extends Local {
	private static final long serialVersionUID = -3189317022423635680L;
	
	private int temperatura=40;
	
	public Deserto(Mundo mundoPertencente) {
		super(mundoPertencente);
	}

}
