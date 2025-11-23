package com.emr.security;

import com.emr.model.Provider;
import com.emr.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderDetailsService implements UserDetailsService {

    private final ProviderRepository providerRepository;

    @Override
    public ProviderDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Provider provider = providerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Provider not found"));
        return new ProviderDetails(provider);
    }
}
