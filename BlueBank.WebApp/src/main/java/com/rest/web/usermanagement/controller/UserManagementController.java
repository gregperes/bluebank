package com.rest.web.usermanagement.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.web.usermanagement.exception.BusinessException;
import com.rest.web.usermanagement.model.dto.AccountDTO;
import com.rest.web.usermanagement.model.dto.ErrorDTO;
import com.rest.web.usermanagement.model.dto.TransferTransactionDTO;
import com.rest.web.usermanagement.model.dto.UserAccountDTO;
import com.rest.web.usermanagement.service.AccountManagementService;


/**
 * Classe com os serviços REST disponíveis
 * 
 * @author emersonmuraro
 *
 */
@RestController
public class UserManagementController {
	
	@Autowired
	private AccountManagementService service;
	
	
	/**
	 * Serviço REST para realizar a transferencia de de valores
	 * de uma conta para outra
	 * 
	 * @param transferTransactionDTO obejto com os dados da operacao de transferencia
	 * @return Retorna HTTPStatus 200 no caso de sucesso ou um JSON de erro com a mensagem do erro.
	 */
	@RequestMapping(value = "/transfer",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> transferAccount(@RequestBody(required=true) TransferTransactionDTO transferTransactionDTO) {
		StringBuilder message = new StringBuilder("Parâmetros inválidos: ");
		boolean error = false;
		if (transferTransactionDTO.getSourceAccount() == null || 
				transferTransactionDTO.getSourceAccount().getAgency() == null ||
				transferTransactionDTO.getSourceAccount().getAccount() == null){
			message.append(" SourceAccount");
			error = true;
		}
		if (transferTransactionDTO.getTargetAccount() == null || 
				transferTransactionDTO.getTargetAccount().getAgency() == null ||
				transferTransactionDTO.getTargetAccount().getAccount() == null){
			message.append(error? ", TargetAccount":" TargetAccount");
			error = true;
		}
		BigDecimal zeroValue = new BigDecimal(0);
		if (transferTransactionDTO.getValue() == null || transferTransactionDTO.getValue().compareTo(zeroValue) <= 0){
			message.append(error? ", Value":" Value");
			error = true;
		}
		if (error){
			ErrorDTO errorDTO =  new ErrorDTO();
			errorDTO.setMensagem(message.toString());
			return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
		}
		try {
			service.transferAccountValue(transferTransactionDTO);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (BusinessException e) {
			ErrorDTO errorDTO =  new ErrorDTO();
			errorDTO.setMensagem(e.getMessage());
			return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.OK);
		}
	}
	
	/**
	 * Metodo para auxiliar nos testes, nao foi totalmente desenvolvido por causa do tempo da prova
	 * apenas o necessario para testar o sistema
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/getAccount",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getAccount(@RequestBody(required=true) AccountDTO account) {
			UserAccountDTO userAccountDTO = service.findByAccount(account);
			return new ResponseEntity<UserAccountDTO>(userAccountDTO, HttpStatus.OK);
	}
	
	/**
	 * Metodo para auxiliar nos testes, nao foi totalmente desenvolvido por causa do tempo da prova
	 * apenas o necessario para testar o sistema
	 * @param userAccount
	 * @return
	 */
	
	@RequestMapping(value = "/register",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> register(@RequestBody(required=true) UserAccountDTO userAccount) {
			service.registerAccount(userAccount);
			return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
