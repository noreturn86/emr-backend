package com.emr.security;

import com.emr.model.Patient;
import com.emr.repository.PatientRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.emr.security.PatientDetails;
import com.emr.security.PatientDetailsService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final ProviderDetailsService providerDetailsService;
    private final PatientDetailsService patientDetailsService;
    private final PatientRepository patientRepository;

    //public endpoints that do not require authentication
    private static final List<String> PUBLIC_URLS = List.of(
            "/patients/register-patient",
            "/api/login-provider",
            "/api/login-patient"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        if (PUBLIC_URLS.contains(path) || request.getMethod().equalsIgnoreCase("OPTIONS")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token = authHeader.substring(7);

        if (!jwtService.isValid(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        try {
            String email = jwtService.extractEmail(token);
            String role = jwtService.extractRole(token); // NEW: read role claim

            Object userDetails;

            if ("PROVIDER".equals(role)) {
                userDetails = providerDetailsService.loadUserByUsername(email);
            } else if ("PATIENT".equals(role)) {
                Patient patient = patientRepository.findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("Patient not found"));
                userDetails = new PatientDetails(patient); // create a PatientDetails class similar to ProviderDetails
            } else {
                throw new RuntimeException("Unknown role in JWT");
            }

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails instanceof ProviderDetails
                                    ? ((ProviderDetails) userDetails).getAuthorities()
                                    : List.of() // patients may have no authorities
                    );

            SecurityContextHolder.getContext().setAuthentication(authToken);

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
