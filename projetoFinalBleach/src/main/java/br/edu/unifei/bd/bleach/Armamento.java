package br.edu.unifei.bd.bleach;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public abstract class Armamento implements Serializable{
	private static final long serialVersionUID = 4746450390967733242L;
	@Id
	@GeneratedValue
	private int id;
	
	private int resistencia;
	private int forcaExtra;
	
	public abstract void liberar(Ser s, Armamento a);
	
}
