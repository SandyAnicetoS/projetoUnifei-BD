package br.edu.unifei.bd.bleach;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class HuecoMundo extends Mundo {
	private static final long serialVersionUID = -2017018766974358197L;
	
	private static HuecoMundo mundo = new HuecoMundo();
	
	private HuecoMundo() {}

	public static HuecoMundo getMundo() {
		return mundo;
	}	
}
