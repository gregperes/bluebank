package com.rest.web.usermanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe com a estrutura inicial para contrução de um DAO.
 * 
 * @author emersonmuraro
 *
 */
public abstract class AbstractDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Obtem a sessão corrente para acesso ao banco.
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Salva a entidade no banco.
	 * @param entity
	 */
	public void persist(Object entity) {
		getSession().persist(entity);
	}

	/**
	 * Remove a entidade do banco.
	 * @param entity
	 */
	public void delete(Object entity) {
		getSession().delete(entity);
	}
	
	/**
	 * Atualiza os dados da entidade no banco.
	 * @param entity
	 */
	public void merge(Object entity) {
		getSession().merge(entity);
	}
}
