package com.rest.web.usermanagement.exception;

/**
 * Exceção utilzada para sinalizar erro de validação no serviço
 * 
 * @author emersonmuraro
 *
 */
public class BusinessException extends Exception{
	
	private String message;

	private static final long serialVersionUID = 3960020828017597561L;
	
	public BusinessException(){
		super();
	}
	
	public BusinessException(String message){
		this.message = message;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
