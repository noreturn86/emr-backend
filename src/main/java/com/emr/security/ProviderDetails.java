package com.emr.security;

import com.emr.model.Provider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class ProviderDetails implements UserDetails {

    private final Provider provider;

    public ProviderDetails(Provider provider) {
        this.provider = provider;
    }

    public Provider getProvider() {
        return provider;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_PROVIDER"));
    }

    @Override
    public String getPassword() {
        return provider.getPassword();
    }

    @Override
    public String getUsername() {
        return provider.getEmail();
    }
}
