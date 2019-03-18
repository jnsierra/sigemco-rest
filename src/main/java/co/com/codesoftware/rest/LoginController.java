package co.com.codesoftware.rest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

@RestController
public class LoginController {

	@Value("${jwt.secret}")
	private String secret;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> login(@RequestParam("user") String user, @RequestParam("password") String password) throws ServletException {
		//final boolean existUser = userService.existUser(login.getEmail(), login.getPassword());
		boolean existUser = true;
		if (!existUser) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");

		final Instant now = Instant.now();

		final String jwt = Jwts.builder()
				.setSubject(user)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(Date.from(now))
				.setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
				.signWith(SignatureAlgorithm.HS512, TextCodec.BASE64.encode(secret))
				.compact();
		return new ResponseEntity<>(jwt, HttpStatus.OK);
	}

}
