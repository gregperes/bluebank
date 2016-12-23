package com.rest.web.usermanagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.rest.web.usermanagement.model.entity.UserAccount;

@Repository("userDao")
public class AccountDaoImpl extends AbstractDao implements AccountDao{


	@Override
	public void saveAccount(UserAccount user) {
		persist(user);
	}

	@Override
	public void deleteAccount(UserAccount user) {
		delete(user);
	}
	
	@Override
	public void updateAccount(UserAccount user){
		merge(user);
	}

	@Override
	public List<UserAccount> listAllAccounts() {
		Query query = getSession().createQuery ("from UserAccount");
		@SuppressWarnings("unchecked")
		List<UserAccount> users = query.list();
		return users;
	}

	@Override
	public UserAccount findByAccount(Integer agency, Integer account) {
		Query query = getSession().createQuery ("from UserAccount where agency = :agency and account = :account");
		query.setParameter("agency", agency);
		query.setParameter("account", account);
		return (UserAccount)query.uniqueResult();
	}

	@Override
	public UserAccount findById(String id) {
		Query query = getSession().createQuery ("from UserAccount where id = :id");
		query.setParameter("id", id);
		return (UserAccount)query.uniqueResult();
	}
	
}
