package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class SoulSociety extends Mundo {
	private static final long serialVersionUID = 2503692402781631987L;
	
	private static SoulSociety mundo = new SoulSociety();
	
	private SoulSociety() {}
	
	public static SoulSociety getMundo() {
		return mundo;
	}
}
