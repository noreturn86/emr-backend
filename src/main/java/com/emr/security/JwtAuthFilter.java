package com.emr.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final ProviderDetailsService providerDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("⛔ No Bearer token");
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        System.out.println("🔍 Token received: " + token);

        // Validate token signature + expiration
        if (!jwtService.isValid(token)) {
            System.out.println("⛔ Token invalid");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        try {
            String email = jwtService.extractEmail(token);
            System.out.println("🔐 Extracted email: " + email);

            // Load provider from DB
            ProviderDetails providerDetails =
                    providerDetailsService.loadUserByUsername(email);

            System.out.println("✅ Loaded provider: " + providerDetails.getUsername());

            // Create Spring Security authentication object
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            providerDetails,
                            null,
                            providerDetails.getAuthorities()
                    );

            // Save authentication in the security context
            SecurityContextHolder.getContext().setAuthentication(authToken);

            System.out.println("✅ Authentication stored in SecurityContext");

        } catch (Exception e) {
            System.out.println("⛔ Authentication error: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // Continue request
        filterChain.doFilter(request, response);
    }
}
