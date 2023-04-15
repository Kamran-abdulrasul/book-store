package com.example.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Objects;
import java.util.Properties;

public class MailConfig {
        private final Environment environment;

    public MailConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
        public JavaMailSender getJavaMailSender() {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

            mailSender.setHost(environment.getProperty("spring.mail.host"));
            mailSender.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("spring.mail.port"))));
            mailSender.setUsername(environment.getProperty("spring.mail.username"));
            mailSender.setPassword(environment.getProperty("spring.mail.password"));


            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");

            return mailSender;
        }
}
