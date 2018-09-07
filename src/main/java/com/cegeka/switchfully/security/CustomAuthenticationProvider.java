package com.cegeka.switchfully.security;

import com.cegeka.switchfully.security.external.authentication.ExternalAuthenticaton;
import com.cegeka.switchfully.security.external.authentication.FakeAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private FakeAuthenticationService fakeAuthenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ExternalAuthenticaton result = fakeAuthenticationService.getUser(authentication.getName(),(String)authentication.getCredentials());
        if (result != null) {
            return new UsernamePasswordAuthenticationToken(result, result.getPassword(),result.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet()));

        }
        throw new AuthenticationCredentialsNotFoundException("username/password doesn't exist");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
