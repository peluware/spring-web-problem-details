package com.peluware.springframework.web.problemdetails.configuration;

import com.peluware.springframework.web.problemdetails.ResponseEntityExceptionHandlerResolver;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * Bean post processor to inject the {@link ProblemDetailsProperties} configuration into beans that implement {@link ProblemDetailsPropertiesAware}.
 */
public class ProblemDetailsConfigurationPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(ProblemDetailsConfigurationPostProcessor.class);
    private final ProblemDetailsProperties properties;
    private final ResponseEntityExceptionHandlerResolver resolver;

    public ProblemDetailsConfigurationPostProcessor(ProblemDetailsProperties properties, ResponseEntityExceptionHandlerResolver resolver) {
        this.properties = properties;
        this.resolver = resolver;
    }

    /**
     * Process the bean before initialization.
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return the bean instance to use, either the original or a wrapped one
     */
    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) {
        log.trace("Processing bean {} of type {}", beanName, bean.getClass().getName());

        if (bean instanceof ProblemDetailsPropertiesAware aware) {
            log.trace("Injecting ProblemDetailsProperties into bean {}", beanName);
            aware.setProblemDetailsProperties(properties);
        }

        if (bean instanceof ResponseEntityExceptionHandlerResolverAware aware) {
            log.trace("Injecting ResponseEntityExceptionHandlerResolver into bean {}", beanName);
            aware.setResponseEntityExceptionHandlerResolver(resolver);
        }

        return bean;
    }

}
