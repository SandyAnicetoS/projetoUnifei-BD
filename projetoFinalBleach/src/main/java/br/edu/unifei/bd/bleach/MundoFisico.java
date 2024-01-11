package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class MundoFisico extends Mundo {
	private static final long serialVersionUID = -509332416706852982L;
	
	private static MundoFisico mundo = new MundoFisico();
	
	private MundoFisico() {}
	
	public static MundoFisico getMundo() {
		return mundo;
	}
}
