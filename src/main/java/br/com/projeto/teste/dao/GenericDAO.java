package br.com.projeto.teste.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.projeto.teste.interceptor.InterceptorTransactional;

@Named
@RequestScoped
public class GenericDAO<T> implements Serializable{

	private static final long serialVersionUID = -4485432433351154877L;
	
	@Inject
	private EntityManager entityManager;
	
	private Class<T> type;
	
	public GenericDAO(Class<T> type) {
		this.type = type;
	}
	
	public T find(Integer id) {
		return (T) entityManager.find(type,id);
	}
	
	public List<T> findAll() {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = builder.createQuery(type);
		Root<T> root = cq.from(type);
		cq.select(root);
		return this.entityManager.createQuery(cq).getResultList();
	}
	
	@Interceptors(InterceptorTransactional.class)
	public T insert(T entidade) {
		entityManager.persist(entidade);
		return entidade;
	}

	@Interceptors(InterceptorTransactional.class)
	public T update(T entidade) {
		entityManager.merge(entidade);
		return entidade;
	}
	
	@Interceptors(InterceptorTransactional.class)
	public T delete(T entidade) {
		entityManager.remove(entidade);
		return entidade;
	}

}
