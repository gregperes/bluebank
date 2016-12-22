package com.rest.web.usermanagement.model.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO como os dados cadastrais do usuário.
 * 
 * @author emersonmuraro
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAccountDTO implements Serializable{
	
	private static final long serialVersionUID = 3864727777606894864L;
	
	private Integer agency;
	
	private Integer account;
	
	private Float value;

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

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

}
