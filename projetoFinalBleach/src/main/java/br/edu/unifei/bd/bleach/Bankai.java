package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Bankai extends Armamento {
	private static final long serialVersionUID = 7498503105708295693L;
	
	private String nome;
	private String fraseDeEfeito;
	private String forma;
	@OneToOne private Habilidade especial;
	
	@Override
	public void liberar(Ser s, Armamento a) {
		if(a instanceof Shinkai) {
			s.setEspada(a);
		}
	}

}
