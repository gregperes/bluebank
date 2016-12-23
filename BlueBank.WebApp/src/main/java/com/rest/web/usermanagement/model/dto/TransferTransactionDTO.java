package com.rest.web.usermanagement.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO como os dados de uma transação de tranferencia.
 * 
 * @author emersonmuraro
 *
 */
public class TransferTransactionDTO implements Serializable{
	
	private static final long serialVersionUID = 366212717815369511L;

	private AccountDTO sourceAccount;
	
	private AccountDTO targetAccount;
	
	private BigDecimal value;

	public AccountDTO getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(AccountDTO sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public AccountDTO getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(AccountDTO targetAccount) {
		this.targetAccount = targetAccount;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
