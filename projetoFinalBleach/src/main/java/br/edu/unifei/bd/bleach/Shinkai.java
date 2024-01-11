package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Shinkai extends Armamento {
	private static final long serialVersionUID = -1974413159773247289L;
	
	private String nome;
	private String forma;
	@OneToOne private Habilidade especial;
	
	@Override
	public void liberar(Ser s, Armamento a) {
		if(a instanceof Bankai) {
			s.setEspada(a);
		}
	}

}
