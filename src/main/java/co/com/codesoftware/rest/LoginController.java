package co.com.codesoftware.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.codesoftware.dto.LoginDto;
import co.com.codesoftware.service.ITokenService;

@RestController
public class LoginController {
	
	@Autowired
	ITokenService tokenService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		return new ResponseEntity<>(tokenService.generateToken(loginDto.getUsuario(), grantedAuthorities), HttpStatus.OK);
	}

}
