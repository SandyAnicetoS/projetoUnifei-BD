package br.edu.unifei.bd.bleach;

import java.util.List;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Fenda extends Local {
	private static final long serialVersionUID = -7888190920386106970L;
	
	private int tempoAberta;
	
	public Fenda(Mundo mundoDePartida) {
		super(mundoDePartida);
	}
	
	public boolean abertura(Ser ser, Local novoLocal) {
		if(tempoAberta<1)
			return false;
	
		ser.getRaca().setReservaEspiritual(ser.getRaca().getReservaEspiritual()-10-(int)(tempoAberta*0.5));
		transportar(this.getHabitantes(), novoLocal);
		return true;
	}
	
	private void transportar(List<Ser> seres, Local destino) {
		for(Ser s : seres) {
			s.getLocalAtual().getHabitantes().remove(s);
			s.setLocalAtual(destino);
			destino.getHabitantes().add(s);
			
		}
	}
}
