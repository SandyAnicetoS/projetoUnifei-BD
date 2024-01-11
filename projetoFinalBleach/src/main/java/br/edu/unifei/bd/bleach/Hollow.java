package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Hollow extends Raca{
	private static final long serialVersionUID = 618046861818035544L;
	
	private int hollowsDevorados;
	private int almasDevoradas;
	@Enumerated(EnumType.STRING)
	private EnumHollow tipo = EnumHollow.COMUM;
	
	public boolean evolucao() {
		if(tipo == EnumHollow.COMUM) {
			if(almasDevoradas+hollowsDevorados>50) {
				tipo = EnumHollow.GILLIAN;
				return true;
			}
		}else if(tipo == EnumHollow.GILLIAN) {
			if(hollowsDevorados>75) {
				tipo = EnumHollow.ADJUNCHA;
				return true;
			}
		}else if(tipo == EnumHollow.ADJUNCHA) {
			if(hollowsDevorados>100) {
				tipo = EnumHollow.VASTOLORD;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void transformacao(Ser s, Raca r) {
		if(r instanceof Arrancar) {
			s.setRaca(r);
		}
	}
	
}

