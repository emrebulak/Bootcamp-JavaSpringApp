package com.emrebulak.auditing;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Log4j2
@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            System.out.println("Sisteme Giriş : " + authentication.getName());
            log.info("Sisteme Giriş : " + authentication.getName());
            log.info("Sisteme Giriş : " + authentication.getPrincipal());
            return Optional.of(authentication.getName());
        }
        return Optional.of("EmreB.");
    }
}
