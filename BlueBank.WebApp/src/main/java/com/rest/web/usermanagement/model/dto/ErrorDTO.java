package com.rest.web.usermanagement.model.dto;

import javax.xml.bind.annotation.XmlElement;

/**
 * DTO para retorno de erro do serviço.
 * @author emersonmuraro
 *
 */
public class ErrorDTO {
	
	@XmlElement(name = "mensagem")
	private String mensagem;

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
