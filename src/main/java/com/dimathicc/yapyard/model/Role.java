package com.dimathicc.yapyard.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_POSTS,
    ROLE_USERS,
    ROLE_ALBUMS;

    @Override
    public String getAuthority() {
        return null;
    }
}
