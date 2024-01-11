package br.edu.unifei.bd.bleach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetoBleach");
		EntityManager em = emf.createEntityManager();
		// exemplos teste
//		em.getTransaction().begin();
//		
//		Habilidade hab1 = new Habilidade();
//		hab1.setNome("Deep Cut");
//		hab1.setDescricao("Causa um corte profundo");
//		hab1.setEfeito(10);
//		
//		Alma alma = new Alma();
//		alma.setTempoDeMorte(20);
//		alma.setProfissao("Vigilante");
//		
//		Humano h = new Humano();
//		h.setQuincy(true);
//		
//		Ser ser1 = new Ser(alma);
//		ser1.setNome("Ichigo");
//		ser1.setReiatsu(50);
//		
//		Ser ser2 = new Ser(alma);
//		ser2.setNome("Retsu");
//		ser2.setReiatsu(60);
//		
//		Ser ser3 = new Ser(h);
//		ser3.setNome("Rukia");
//		ser1.setReiatsu(70);
//		
//		Ser ser4 = new Ser(h);
//		ser4.setNome("Nel");
//		ser2.setReiatsu(90);
//		
//		Organizacao org1 = new Organizacao();
//		org1.setNome("Organização das Fendas");
//		org1.setRegras("Regra 1: vigiar as Fendas");
//		
//		ser1.setOrganizacao(org1);
//		ser2.setOrganizacao(org1);
//		
//		em.persist(hab1);
//		em.persist(alma);
//		em.persist(h);
//		em.persist(ser1);
//		em.persist(ser2);
//		em.persist(ser3);
//		em.persist(ser4);
//		em.persist(org1);
//		
//		em.getTransaction().commit();
		em.close();
		emf.close();
		
		System.out.println("Pronto.");
		
	}
}
