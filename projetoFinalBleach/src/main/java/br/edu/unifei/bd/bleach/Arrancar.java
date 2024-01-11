package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Arrancar extends Raca{
	private static final long serialVersionUID = -1653708755326090625L;
	
	private int hollowsDevorados;
	private int almasDevoradas;
	private EnumHollow tipo = EnumHollow.ADJUNCHA;
	
	@Override
	public void transformacao(Ser s, Raca r) {}

}
