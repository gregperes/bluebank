package com.rest.web.usermanagement.dao;

import java.util.List;

import com.rest.web.usermanagement.model.entity.UserAccount;

public interface UserDao {
	/**
	 * Recupera o agencia e conta cadastrada
	 * @param email
	 * @return
	 */
	UserAccount findByAccount(Integer agency, Integer account);
	void saveUser(UserAccount user);
	void deleteUser(UserAccount user);
	
	/**
	 * Lista todos as agencias e contas cadastradas.
	 * @return
	 */
	List<UserAccount> listAllAccounts();
	
	/**
	 * Recupera o usuário pelo id.
	 * @param id
	 * @return
	 */
	UserAccount findById(String id);
	void updateUser(UserAccount user);
}
