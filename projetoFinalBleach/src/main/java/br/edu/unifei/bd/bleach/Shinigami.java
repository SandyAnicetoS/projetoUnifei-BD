package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Shinigami extends Raca {
	private static final long serialVersionUID = -8640163768351409122L;
	
	private boolean possuiBankai;
	private int afinidadeZanpakuto;
	
	@Override
	public void transformacao(Ser ser, Raca raca) {
		ser.setRaca(raca);
	}
	
	public void liberarArmamento(Ser s, Armamento a) {
		if(afinidadeZanpakuto>=100) {
			s.getEspada().liberar(s, a);
		}
	}
	
	public void ceifar(Ser ser, Local local) {
		if((ser.getRaca() instanceof Alma)&&
				(ser.getLocalAtual().getMundoPertencente() instanceof MundoFisico)) {
			ser.setLocalAtual(local);
		}
	}
}
