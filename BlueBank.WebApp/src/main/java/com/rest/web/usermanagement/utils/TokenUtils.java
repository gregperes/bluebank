package com.rest.web.usermanagement.utils;

import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

/**
 * Classe com os recursos para manipulação do token JWT
 * 
 * @author emersonmuraro
 *
 */
public class TokenUtils {
	
	public static final String SECRET_KEY = "concreteSolutonSecretkey";
	public static final String JWT_ISSUER = "UserManagementAPI";
	public static final String JWT_ROLE = "ALL";

	/**
	 * Cria um token JWT
	 * 
	 * @param userName e-mail do usuário
	 * @param creationDate data de criação do token
	 * @param timeout date de expiração do token
	 * @return String com o token compactado.
	 */
	public static String generateJwt(String userName, Date creationDate, String timeout){
		Calendar calExpiration = Calendar.getInstance();
		calExpiration.setTime(creationDate);
		calExpiration.add(Calendar.MINUTE, Integer.parseInt(timeout));
		
		return Jwts.builder().setIssuer(JWT_ISSUER).setSubject(userName)
	            .claim("roles", JWT_ROLE).setIssuedAt(creationDate).setExpiration(calExpiration.getTime())
	            .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	/**
	 * Valida a chave do token e obtem as informações do token de forma estruturada
	 * 
	 * @param token
	 * @return Objeto com as informações do token
	 * @throws SignatureException
	 * @throws ExpiredJwtException
	 */
	public static Claims getClaims(String token)throws SignatureException, ExpiredJwtException {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	/**
	 * Valida as informações do token do request com a do token armazenado com o seu usuário.
	 * 
	 * @param requestClaims objeto com as informações do token obtido a partir do header
	 * @param userToken token obtido a partir do usuário cadastrado.
	 * @return True se o token for válido.
	 * @throws SignatureException erro ao ler o token
	 * @throws ExpiredJwtException sessão expirou.
	 */
	public static boolean validateToken(Claims requestClaims, String userToken)throws SignatureException, ExpiredJwtException {
		Claims claimsRegister = TokenUtils.getClaims(userToken);
		String role = claimsRegister.get("roles", String.class);
		
		return requestClaims.getIssuer().equals(claimsRegister.getIssuer()) &&
				requestClaims.getSubject().equals(claimsRegister.getSubject()) &&
				requestClaims.getIssuedAt().equals(claimsRegister.getIssuedAt()) &&
				JWT_ROLE.equals(role);
		
	}
}
