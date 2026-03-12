package com.peluware.springframework.web.problemdetails;

import com.peluware.springframework.web.problemdetails.configuration.ProblemDetailsConfigurationPostProcessor;
import com.peluware.springframework.web.problemdetails.configuration.ProblemDetailsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@AutoConfiguration
@ConditionalOnWebApplication
@EnableConfigurationProperties(ProblemDetailsProperties.class)
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class ProblemDetailsAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ProblemDetailsAutoConfiguration.class);

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public static ProblemDetailsConfigurationPostProcessor problemDetailsConfigurationPostProcessor(ProblemDetailsProperties properties) {
        log.debug("Creating ProblemDetailsConfigurationPostProcessor with properties {}", properties);
        return new ProblemDetailsConfigurationPostProcessor(properties);
    }

    @Bean
    @ConditionalOnMissingBean(ResponseEntityExceptionHandler.class)
    public DefaultProblemDetailsExceptionHandler defaultExceptionHandler() {
        log.debug("Creating default exception handler");
        return new DefaultProblemDetailsExceptionHandler();
    }
}