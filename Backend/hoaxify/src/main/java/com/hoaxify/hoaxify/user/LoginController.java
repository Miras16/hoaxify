package com.hoaxify.hoaxify.user;

import com.hoaxify.hoaxify.error.ApiError;
import com.hoaxify.hoaxify.shared.CurrentUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.AcceptPendingException;
import java.util.Collections;
import java.util.Map;

@RestController
public class LoginController {
	
	@PostMapping("/api/1.0/login")
	Map<String, Object> handleLogin(@CurrentUser User loggedInUser) {
		return Collections.singletonMap("id", loggedInUser.getId());
	}


}
