package com.rest.web.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.web.usermanagement.component.AccountTransferOperation;
import com.rest.web.usermanagement.dao.AccountDao;
import com.rest.web.usermanagement.exception.BusinessException;
import com.rest.web.usermanagement.model.dto.AccountDTO;
import com.rest.web.usermanagement.model.dto.TransferTransactionDTO;
import com.rest.web.usermanagement.model.dto.UserAccountDTO;
import com.rest.web.usermanagement.model.entity.UserAccount;

/**
 * Classe dos serviços reponsável pelas regras de negócio.
 * 
 * @author emersonmuraro
 *
 */
@Service("accountManagementService")

public class AccountManagementServiceImpl implements AccountManagementService{
	
	@Value("${session.timeout:30}")
	private String timeout;
	
	@Autowired
	private AccountTransferOperation accountTransferOperation;
	
	@Autowired
	private AccountDao accountDao;

	@Transactional
	public UserAccountDTO findByAccount(AccountDTO accountDTO) {
		UserAccount userAccount = accountDao.findByAccount(accountDTO.getAgency(), accountDTO.getAccount());
		return userAccount!=null? UserAccountDTO.convertUserAccountToUserAccountDTO(userAccount) : null;
	}

	@Transactional(rollbackFor = Exception.class)
	public void transferAccountValue(TransferTransactionDTO transferDTO) throws BusinessException{
		accountTransferOperation.transferOperation(transferDTO);
	}
	
	@Transactional
	public void registerAccount(UserAccountDTO userAccountDTO){
		accountDao.saveAccount(userAccountDTO.toUserAccount());
	}
}
