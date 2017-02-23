package com.rest.web.usermanagement.model.dto;

import java.math.BigDecimal;

import com.rest.web.usermanagement.model.entity.UserAccount;

/**
 * 
 * @author emersonmuraro
 *
 */
public class UserAccountDTO extends AccountDTO{

	private static final long serialVersionUID = 3011951571241743003L;
	
	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public static UserAccountDTO convertUserAccountToUserAccountDTO(UserAccount userAccount){
		UserAccountDTO result = new UserAccountDTO();
		result.setAccount(userAccount.getAccount());
		result.setAgency(userAccount.getAgency());
		result.setValue(userAccount.getValue());
		
		return result;
	}
	
	public UserAccount toUserAccount(){
		UserAccount userAccount = new UserAccount();
		userAccount.setAgency(this.getAgency());
		userAccount.setAccount(this.getAccount());
		userAccount.setValue(this.value);
		return userAccount;
	}
}
