package br.com.projeto.teste.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManager {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("app_crud_pessoa");
	private EntityManager em = factory.createEntityManager();
	
	public EntityManager getEntityManager() {
		return em;
	}
}
