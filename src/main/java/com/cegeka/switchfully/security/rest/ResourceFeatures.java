package com.cegeka.switchfully.security.rest;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
public enum  ResourceFeatures {
    GET_DEPLOYMENT(Role.PRIVATE,Role.GENERAL),
    JOIN_ARMY(Role.CIVILIAN),
    PROMOTE(Role.HUMAN_RELATIONSHIPS),
    DISCHARGE(Role.HUMAN_RELATIONSHIPS),
    NUKE(Role.GENERAL);

    ResourceFeatures(Role... roles) {
        this.roles = asList(roles);
    }

    private Collection<Role> roles;

    public Collection<Role> getRoles() {
        return roles;
    }

    public static List<ResourceFeatures> getFeaturesForRole(Role role){
        return Arrays.stream(ResourceFeatures.values()).filter(feature -> feature.getRoles().contains(role)).collect(Collectors.toList());
    }
}
