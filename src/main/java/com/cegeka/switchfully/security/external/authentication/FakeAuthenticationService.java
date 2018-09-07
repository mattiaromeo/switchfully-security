package com.cegeka.switchfully.security.external.authentication;

import com.cegeka.switchfully.security.rest.Role;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class FakeAuthenticationService {

    private List<ExternalAuthenticaton> externalAuthenticatons = newArrayList(
            ExternalAuthenticaton.externalAuthenticaton().withUsername("ZWANETTA").withPassword("WORST").withRoles(Collections.singletonList(Role.CIVILIAN)),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("JMILLER").withPassword("THANKS").withRoles(Collections.singletonList(Role.PRIVATE)),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("UNCLE").withPassword("SAM").withRoles(Collections.singletonList(Role.HUMAN_RELATIONSHIPS)),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("GENNY").withPassword("RALLY").withRoles(Collections.singletonList(Role.GENERAL))
    );

    public ExternalAuthenticaton getUser(String username, String password) {
        return externalAuthenticatons.stream()
                .filter(externalAuthenticaton -> externalAuthenticaton.getUsername().equals(username))
                .filter(externalAuthenticaton -> externalAuthenticaton.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
