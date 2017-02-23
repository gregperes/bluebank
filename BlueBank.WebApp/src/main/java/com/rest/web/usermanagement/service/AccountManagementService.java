package com.rest.web.usermanagement.service;

import com.rest.web.usermanagement.exception.BusinessException;
import com.rest.web.usermanagement.model.dto.AccountDTO;
import com.rest.web.usermanagement.model.dto.TransferTransactionDTO;
import com.rest.web.usermanagement.model.dto.UserAccountDTO;

public interface AccountManagementService {

	UserAccountDTO findByAccount(AccountDTO accountDTO);
	void registerAccount(UserAccountDTO userAccountDTO);
	void transferAccountValue(TransferTransactionDTO transferDTO) throws BusinessException;
	
}
