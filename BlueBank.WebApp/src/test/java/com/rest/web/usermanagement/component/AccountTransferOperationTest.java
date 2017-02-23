package com.rest.web.usermanagement.component;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.rest.web.usermanagement.dao.AccountDao;
import com.rest.web.usermanagement.exception.BusinessException;
import com.rest.web.usermanagement.model.dto.AccountDTO;
import com.rest.web.usermanagement.model.dto.TransferTransactionDTO;
import com.rest.web.usermanagement.model.entity.UserAccount;

@RunWith(MockitoJUnitRunner.class)
public class AccountTransferOperationTest {
	

	@InjectMocks
	private AccountTransferOperation accountOperation;
	
	@Mock
	private AccountDao accountDao;
	
	@Before
	public void inti(){
	}
	
	@Test(expected=BusinessException.class)
	public void testTransferTransactionAccountNotFound() throws BusinessException{
		TransferTransactionDTO transferTransactionDTO = new TransferTransactionDTO();
		AccountDTO source = new AccountDTO();
		source.setAccount(1234);
		source.setAgency(321);
		AccountDTO target = new AccountDTO();
		target.setAccount(5678);
		target.setAgency(765);
		transferTransactionDTO.setSourceAccount(source);
		transferTransactionDTO.setTargetAccount(target);
		transferTransactionDTO.setValue(new BigDecimal(150.23));
		
		when(accountDao.findByAccount(any(Integer.class), any(Integer.class))).thenReturn(null);
		
		accountOperation.transferOperation(transferTransactionDTO);
	}
	
	@Test(expected=BusinessException.class)
	public void testTransferTransactionNullParameter() throws BusinessException{
		accountOperation.transferOperation(null);
	}
	
	@Test(expected=BusinessException.class)
	public void testTransferTransactionAccountIsEmpity() throws BusinessException{
		TransferTransactionDTO transferTransactionDTO = new TransferTransactionDTO();
		
		accountOperation.transferOperation(transferTransactionDTO);
	}
	
	@Test(expected=BusinessException.class)
	public void testTransferTransactionAccountBalancenNotEnough() throws BusinessException{
		TransferTransactionDTO transferTransactionDTO = new TransferTransactionDTO();
		AccountDTO source = new AccountDTO();
		source.setAccount(1234);
		source.setAgency(321);
		AccountDTO target = new AccountDTO();
		target.setAccount(5678);
		target.setAgency(765);
		transferTransactionDTO.setSourceAccount(source);
		transferTransactionDTO.setTargetAccount(target);
		transferTransactionDTO.setValue(new BigDecimal(150.23));
		
		UserAccount userAccount = new UserAccount();
		userAccount.setAgency(321);
		userAccount.setAccount(1234);
		userAccount.setValue(new BigDecimal(10.00));
		
		when(accountDao.findByAccount(any(Integer.class), any(Integer.class))).thenReturn(userAccount);
		
		accountOperation.transferOperation(transferTransactionDTO);
	}
	
	@Test
	public void testTransferTransactionAccountSuccess() throws BusinessException{
		TransferTransactionDTO transferTransactionDTO = new TransferTransactionDTO();
		AccountDTO source = new AccountDTO();
		source.setAccount(1234);
		source.setAgency(321);
		AccountDTO target = new AccountDTO();
		target.setAccount(5678);
		target.setAgency(765);
		transferTransactionDTO.setSourceAccount(source);
		transferTransactionDTO.setTargetAccount(target);
		transferTransactionDTO.setValue(new BigDecimal(150.23));
		
		UserAccount sourceAccount = new UserAccount();
		sourceAccount.setAgency(321);
		sourceAccount.setAccount(1234);
		sourceAccount.setValue(new BigDecimal(200.00));
		
		UserAccount targetAccount = new UserAccount();
		targetAccount.setAgency(321);
		targetAccount.setAccount(1234);
		targetAccount.setValue(new BigDecimal(10.00));
		
		when(accountDao.findByAccount(eq(source.getAgency()), eq(source.getAccount()))).thenReturn(sourceAccount);
		when(accountDao.findByAccount(eq(target.getAgency()), eq(target.getAccount()))).thenReturn(targetAccount);
		
		accountOperation.transferOperation(transferTransactionDTO);
	}

}
