package com.rest.web.usermanagement.component;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.web.usermanagement.dao.AccountDao;
import com.rest.web.usermanagement.exception.BusinessException;
import com.rest.web.usermanagement.model.dto.AccountDTO;
import com.rest.web.usermanagement.model.dto.TransferTransactionDTO;
import com.rest.web.usermanagement.model.entity.UserAccount;

@Component
public class AccountTransferOperation {

	@Autowired
	private AccountDao accountDao;
	
	private UserAccount validateSourceTranferAccount(AccountDTO sourceAccount, BigDecimal value) throws BusinessException{
		if (sourceAccount == null){
			throw new BusinessException("Agencia e conta do usuário corrente não informados.");
		}
		UserAccount source = accountDao.findByAccount(sourceAccount.getAgency(), sourceAccount.getAccount());
		if (source == null){
			throw new BusinessException("Agencia e conta do usuário corrente não cadastrados.");
		}
		
		if (source.getValue().compareTo(value) < 0){
			throw new BusinessException("Saldo insuficiente na conta do usuário.");
		}
		return source;
	}
	
	private UserAccount validateTargetTranferAccount(AccountDTO targetAccount) throws BusinessException{
		if (targetAccount == null){
			throw new BusinessException("Agencia e conta do usuário de destino não informados.");
		}
		UserAccount source = accountDao.findByAccount(targetAccount.getAgency(), targetAccount.getAccount());
		if (source == null){
			throw new BusinessException("Agencia e conta do usuário de destino não cadastrados.");
		}
		
		return source;
	}
	
	public void transferOperation(TransferTransactionDTO transferTransactionDTO) throws BusinessException{
		if (transferTransactionDTO == null){
			throw new BusinessException("Dados de transferencia nulos.");
		}
		UserAccount sourceUserAccount = validateSourceTranferAccount(transferTransactionDTO.getSourceAccount(), transferTransactionDTO.getValue());
		UserAccount targetUserAccount = validateTargetTranferAccount(transferTransactionDTO.getTargetAccount());
		
		transferValues(sourceUserAccount, targetUserAccount, transferTransactionDTO.getValue());
		accountDao.updateAccount(sourceUserAccount);
		accountDao.updateAccount(targetUserAccount);
	}
	
	private void transferValues(UserAccount source, UserAccount target, BigDecimal value){
		BigDecimal newSourceValue = source.getValue().subtract(value);
		BigDecimal newTargetValue = target.getValue().add(value);
		
		source.setValue(newSourceValue);
		target.setValue(newTargetValue);
	}
	
}
