package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Zanpakuto extends Armamento{
	private static final long serialVersionUID = 3604896542551570980L;

	@Override
	public void liberar(Ser s, Armamento a) {
		if(a instanceof Shinkai) {
			s.setEspada(a);
		}
	}
}
