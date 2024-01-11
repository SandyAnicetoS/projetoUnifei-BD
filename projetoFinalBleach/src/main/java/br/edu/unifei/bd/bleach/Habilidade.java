package br.edu.unifei.bd.bleach;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Entity
@Data
public class Habilidade implements Serializable{
	private static final long serialVersionUID = -1685290842101127979L;
	
	@Id
	private String nome;
	private int gasto;
	private int efeito;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private EnumHabilidade tipo = EnumHabilidade.DANO;
	
	public boolean usarHabilidadeControlada(Ser alvo, Ser usuario, int energia) {
		usuario.getRaca().setReservaEspiritual(usuario.getRaca().getReservaEspiritual()-gasto-energia);
		if(tipo == EnumHabilidade.DANO) {
			if(usuario.getRaca().getForca()>alvo.getRaca().getDefesa()) {
				alvo.getRaca().setVida(alvo.getRaca().getDefesa()-(int)(efeito*energia/3));
				alvo.getRaca().setDefesa(alvo.getRaca().getDefesa()-(int)(efeito*energia/4));
				return true;
			}
		}else if (tipo == EnumHabilidade.CURA) {
			if(alvo.getRaca().getVida()>0) {
				alvo.getRaca().setVida(alvo.getRaca().getVida()+(int)(efeito*energia/2));
				return true;
			}
		}else if(tipo == EnumHabilidade.DEFESA) {
			alvo.getRaca().setDefesa(alvo.getRaca().getDefesa()+(int)(efeito*energia/2));
			return true;
		}
		return false;
	}
}
