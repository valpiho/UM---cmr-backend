package com.pibox.um.listener;

import com.pibox.um.service.LoginAttemptService;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class AuthenticationFailureListener {

    private final LoginAttemptService loginAttemptService;

    public AuthenticationFailureListener(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }

    @EventListener
    public void onAuthenticationFailure(AuthenticationFailureBadCredentialsEvent event) {
        Object principal = event.getAuthentication().getPrincipal();
        if (principal instanceof String) {
            String username = (String) event.getAuthentication().getPrincipal();
            loginAttemptService.addUserToLoginAttemptCache(username);
        }
    }
}
