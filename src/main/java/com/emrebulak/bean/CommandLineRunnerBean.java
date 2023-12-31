package com.emrebulak.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class CommandLineRunnerBean {
    public CommandLineRunner commandLineRunnerMethod() {
        return args -> {
            log.info("Data set oluşturuldu");
        };
    }

}
