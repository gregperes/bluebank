package com.rest.web.usermanagement.service;

import java.util.List;

import com.rest.web.usermanagement.exception.BusinessException;
import com.rest.web.usermanagement.model.dto.UserAccountDTO;

public interface AccountManagementService {
	void saveUser(UserAccountDTO accountDTO)throws BusinessException;
	void deleteUser(UserAccountDTO accountDTO);
	List<UserAccountDTO> listAllAccounts();
	UserAccountDTO findById(String id);
}
