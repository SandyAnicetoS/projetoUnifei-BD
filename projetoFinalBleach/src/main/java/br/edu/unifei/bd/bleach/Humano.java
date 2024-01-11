package br.edu.unifei.bd.bleach;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Humano extends Raca {
	private static final long serialVersionUID = 5185261290599559953L;
	
	private boolean quincy;
	private boolean percepcaoEspiritual;
	@OneToMany private List<ArmamentoEspiritual> armamento = new ArrayList<ArmamentoEspiritual>();
	
	public void virarQuincy() {
		if(percepcaoEspiritual) {
			quincy = true;
		}else{
			System.out.println("O humano deve poder ver espritos\n");
		}
	}
	@Override
	public void transformacao(Ser s, Raca r){
		if(!(r instanceof Arrancar)) {
			s.setRaca(r);
		}
	}

}
