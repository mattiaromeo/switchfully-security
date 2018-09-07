package com.cegeka.switchfully.security.external.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class FakeAuthenticationService {

    @Autowired
    private PasswordEncoder passwordEncoder ;

    private List<ExternalAuthenticaton> externalAuthenticatons = newArrayList(
            ExternalAuthenticaton.externalAuthenticaton().withUsername("ZWANETTA").withPassword("$2a$04$4q9hddsNQkdn7Zk/M4UeDejJ/S1dwlwfLgr2AbAusoMR8FRdxghnW").withRoles(newArrayList("CIVILIAN")),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("JMILLER").withPassword("$2a$04$BwbsxBZy6Ei3V7LEN0g36O0D4V7cAPs9bar.uBsXGI1Z1PhOSCLf2").withRoles(newArrayList("PRIVATE")),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("UNCLE").withPassword("$2a$04$taFg25/v8Za9ovVR9y1IcuuupHU44nHbL7AvavjeLkBBjTDquKdXS").withRoles(newArrayList("HUMAN_RELATIONSHIPS")),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("GENNY").withPassword("$2a$04$zbeRu8CRLNkEfhhUm4LnveA3TJL2OFJI9rfe1iY2X/xHPURGrIWcm").withRoles(newArrayList("GENERAL"))
    );

    public ExternalAuthenticaton getUser(String username, String password) {
        return externalAuthenticatons.stream()
                .filter(externalAuthenticaton -> externalAuthenticaton.getUsername().equals(username))
                .filter(externalAuthenticaton -> passwordEncoder.matches(password,externalAuthenticaton.getPassword()))
                .findFirst()
                .orElse(null);
    }
}
