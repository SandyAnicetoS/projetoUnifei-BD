package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Alma extends Raca {
	private static final long serialVersionUID = -711064667463600345L;
	
	private boolean ceifado;
	private int tempoDeMorte;
	private String profissao;
	
	@Override
	public void transformacao(Ser ser, Raca raca) {
		ser.setRaca(raca);
	}
	
}
