package com.rest.web.usermanagement.model.dto;

import java.io.Serializable;

/**
 * 
 * @author emersonmuraro
 *
 */
public class AccountDTO implements Serializable{

	private static final long serialVersionUID = -6255529912074478934L;

	protected Integer agency;
	
	protected Integer account;

	public Integer getAgency() {
		return agency;
	}

	public void setAgency(Integer agency) {
		this.agency = agency;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}
	

}
