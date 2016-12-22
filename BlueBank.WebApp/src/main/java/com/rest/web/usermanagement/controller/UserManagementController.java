package com.rest.web.usermanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.web.usermanagement.exception.BusinessException;
import com.rest.web.usermanagement.model.dto.ErrorDTO;
import com.rest.web.usermanagement.model.dto.LoginDTO;
import com.rest.web.usermanagement.model.dto.UserAccountDTO;
import com.rest.web.usermanagement.model.dto.UserDTO;
import com.rest.web.usermanagement.service.AccountManagementService;
import com.rest.web.usermanagement.utils.TokenUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;


/**
 * Classe com os serviços REST disponíveis
 * 
 * @author emersonmuraro
 *
 */
@RestController
public class UserManagementController {
	
	private static final String UNAUTHORIZED = "Não autorizado";
	private static final String INVALID_SESSION = "Sessão inválida";
	
	@Autowired
	private AccountManagementService service;
	
	
	/**
	 * Serviço REST para cadastro de um novo usuário.
	 * 
	 * @param simpleUserDTO dados do usuário
	 * @return Retorna o JSON do {@link UserDTO} para o sucesso do casdastro ou
	 * retorna um JSON do {@link ErrorDTO} em caso de erro de validação.
	 */
	@RequestMapping(value = "/register",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> register(@RequestBody(required=true) UserAccountDTO simpleUserDTO) {
		StringBuilder message = new StringBuilder("Parâmetros inválidos: ");
		boolean error = false;
		if (simpleUserDTO.getName() == null || simpleUserDTO.getName().isEmpty()){
			message.append(" Nome");
			error = true;
		}
		if (simpleUserDTO.getEmail() == null || simpleUserDTO.getEmail().isEmpty()){
			message.append(error? ", Email":" Email");
			error = true;
		}
		if (simpleUserDTO.getPassword() == null || simpleUserDTO.getPassword().isEmpty()){
			message.append(error? ", Password":" Password");
			error = true;
		}
		if (error){
			ErrorDTO errorDTO =  new ErrorDTO();
			errorDTO.setMensagem(message.toString());
			return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setSimpleUserDTO(simpleUserDTO);
		try {
			service.saveUser(userDTO);
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
		} catch (BusinessException e) {
			ErrorDTO errorDTO =  new ErrorDTO();
			errorDTO.setMensagem(e.getMessage());
			return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.OK);
		}
	}
	
	/**
	 * Serviço REST para listar todos os usuários cadastrados na base.
	 * Precisa estar authenticado para realizar este serviço
	 * 
	 * @param id identificador do usuário que realizou o login
	 * @param request header com o token (Authorization) para validação do usuário
	 * @return Json com a lista de {@link UserAccountDTO} cadastrados
	 */
	@RequestMapping(value = "/listAll",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> listAll(@RequestParam(value="id", required=true) String id, final HttpServletRequest request) {
		try{	
			Claims claimsRequest = getHeaderClaims(request);
			UserDTO userDTO = service.findById(id);
			if (userDTO == null){
				return getUnauthorizedError(UNAUTHORIZED);
			}
			if (TokenUtils.validateToken(claimsRequest, userDTO.getToken())){
				List<UserAccountDTO> result = service.listAllUsers();
				return new ResponseEntity<List<UserAccountDTO>>(result, HttpStatus.OK);
			}else{
				return getUnauthorizedError(UNAUTHORIZED);
			}
		} catch (SignatureException e) {
			return getUnauthorizedError(UNAUTHORIZED);
		} catch (ExpiredJwtException e){
			return getUnauthorizedError(INVALID_SESSION);
		}

	}
	
	
	/**
	 * Serviço REST para validar o perfil do usuário, ou seja, se ele possuem um token válido
	 * 
	 * @param id  identificador do usuário que realizou o login
	 * @param request header com o token (Authorization) para validação do usuário
	 * @return Retorna um JSON com o dados da autenticação do usuário {@link UserDTO}
	 */
	@RequestMapping(value = "/perfil",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> perfil(@RequestParam(value="id", required=true) String id, final HttpServletRequest request) {
		try {
			Claims claimsRequest = getHeaderClaims(request);
			UserDTO userDTO = service.findById(id);
			if (userDTO == null){
				return getUnauthorizedError(UNAUTHORIZED);
			}
			if (TokenUtils.validateToken(claimsRequest, userDTO.getToken())){
				return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
			}else{
				return getUnauthorizedError(UNAUTHORIZED);
			}
		} catch (SignatureException e) {
			return getUnauthorizedError(UNAUTHORIZED);
		} catch (ExpiredJwtException e){
			return getUnauthorizedError(INVALID_SESSION);
		}
	}
	
	/**
	 * Serviço REST de login
	 * 
	 * @param login Usuario e senha para autenticação
	 * @return Retorna o JSON do {@link UserDTO} com as informações de autenticação do usuário
	 */
	@RequestMapping(value = "/login",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> perfil(@RequestBody(required=true) LoginDTO login) {
		StringBuilder message = new StringBuilder("Parâmetros inválidos: ");
		boolean error = false;
		//verifica os campos obrigatórios
		if (login.getEmail() == null || login.getEmail().isEmpty()){
			message.append(" Email");
			error = true;
		}
		if (login.getPassword() == null || login.getPassword().isEmpty()){
			message.append(error? ", Password":" Password");
			error = true;
		}
		if (error){
			ErrorDTO errorDTO =  new ErrorDTO();
			errorDTO.setMensagem(message.toString());
			return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
		}
		
		//faz o login do usuário
		try {
			UserDTO userDTO = service.login(login);
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
		} catch (BusinessException e) {
			ErrorDTO errorDTO =  new ErrorDTO();
			errorDTO.setMensagem(e.getMessage());
			return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.UNAUTHORIZED);
		}
	}
	
	/**
	 * Cria o objeto do erro Unauthorized para retorno no serviço 
	 * 
	 * @param message texto da mensagem a ser exibida para o erro
	 * @return
	 */
	private ResponseEntity<ErrorDTO> getUnauthorizedError(String message){
		ErrorDTO error = new ErrorDTO();
		error.setMensagem(message);
		return new ResponseEntity<ErrorDTO>(error, HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Recupera o token do header do request
	 * 
	 * @param request
	 * @return {@link Claims} com as informações do token
	 * @throws SignatureException
	 */
	private Claims getHeaderClaims(final HttpServletRequest request)throws SignatureException{ 
        final String token = request.getHeader("Authorization");
        if (token == null) {
            throw new SignatureException("Missing token.");
        }
        return TokenUtils.getClaims(token);
	}

}
