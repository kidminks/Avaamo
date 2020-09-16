package com.example.AvaamoTestBackend;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.concurrent.Executor;

@SpringBootApplication
@Log4j2
@EnableScheduling
@EnableAsync
public class AvaamoTestBackendApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AvaamoTestBackendApplication.class);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AvaamoTestBackendApplication.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();

        Arrays.sort(beanNames);

        log.debug("---------- Beans Registered -----------");

        for (String beanName : beanNames) {
            log.debug(beanName);
        }

        log.debug("---------------- Done -----------------");
    }

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int numOfCores = Runtime.getRuntime().availableProcessors();
        executor.setCorePoolSize(numOfCores + 1);
        executor.setMaxPoolSize(100);
        executor.setThreadNamePrefix("TaskExecutor-");
        executor.initialize();
        return executor;
    }

}

