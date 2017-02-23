package com.rest.web.usermanagement.dao;

import java.util.List;

import com.rest.web.usermanagement.model.entity.UserAccount;

public interface AccountDao {
	/**
	 * Recupera o agencia e conta cadastrada
	 * @param email
	 * @return
	 */
	UserAccount findByAccount(Integer agency, Integer account);
	void saveAccount(UserAccount userAccount);
	void deleteAccount(UserAccount userAccount);
	
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
	void updateAccount(UserAccount userAccount);
}
