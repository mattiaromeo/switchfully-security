package com.cegeka.switchfully.security.external.authentication;

import com.cegeka.switchfully.security.rest.Role;

import java.util.List;

public class ExternalAuthenticaton {
    private String username;
    private String password;
    private List<Role> roles;

    public static ExternalAuthenticaton externalAuthenticaton(){
        return new ExternalAuthenticaton();
    }

    public ExternalAuthenticaton withUsername(String username) {
        this.username = username;
        return this;
    }

    public ExternalAuthenticaton withPassword(String password) {
        this.password = password;
        return this;
    }

    public ExternalAuthenticaton withRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
