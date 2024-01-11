package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ArmamentoEspiritual extends Armamento{
	private static final long serialVersionUID = 4952030170052917243L;
	
	private String nome;
	private String descricao;
	private int limiteEspirital;
	private boolean quebrado;
	@OneToOne private Habilidade habilidade = new Habilidade();
	
	public boolean usarArmamento(Ser s, int energia, Ser alvo) {
		if(s.getRaca() instanceof Humano) {
			if(energia>limiteEspirital) {
				quebrado = true;
				return false;
			}else if(s.getLocalAtual().getConcentracaoEspiritual()>energia) {
				habilidade.setEfeito(energia);
				habilidade.usarHabilidadeControlada(s, alvo, 1);
				s.getLocalAtual().setConcentracaoEspiritual(s.getLocalAtual().getConcentracaoEspiritual()-energia);
				return true;
			}
		}
		return false;
	}
	
	public ArmamentoEspiritual() {
		habilidade.setTipo(EnumHabilidade.DANO);
	}
	
	@Override public void liberar(Ser s, Armamento a) {}
	
}
