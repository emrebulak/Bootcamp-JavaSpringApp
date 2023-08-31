package com.emrebulak.bean;

import com.emrebulak.auditing.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean {
    @Bean
    public AuditorAware<String> auditorAwareBeanMethod() {
        return new AuditorAwareImpl();
    }
}
