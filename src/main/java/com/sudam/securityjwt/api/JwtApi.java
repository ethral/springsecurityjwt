package com.sudam.securityjwt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudam.securityjwt.model.AuthenticationRequest;
import com.sudam.securityjwt.model.AuthenticationResponse;
import com.sudam.securityjwt.util.JwtUtil;

@RestController
public class JwtApi {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@GetMapping("/")
	public String hola() {
		return ("Hola Mi Amigo!");
	}
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authReq) throws Exception {
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
		} catch (BadCredentialsException e) {
			// TODO Auto-generated catch block
			throw new Exception("Incorrect username of password", e);
		}
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authReq.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}

}
