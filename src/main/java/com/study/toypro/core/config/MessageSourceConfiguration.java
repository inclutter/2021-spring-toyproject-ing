package com.study.toypro.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.StaticMessageSource;

@Configuration
public class MessageSourceConfiguration {
    @Value("${spring.messages.basename}")
    private String messagesBasename = null;

    @Value("${spring.messages.encoding}")
    private String messagesEncoding = null;

    /**
     * Configuraiton MessageSource;
     *
     * @return
     */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding(messagesEncoding);
        messageSource.setBasenames(messagesBasename);

        messageSource.setFallbackToSystemLocale(false);
        messageSource.setUseCodeAsDefaultMessage(false);
        return messageSource;
    }

    /**
     * Configuration MessageAccessor
     *
     * @return
     */
    @Bean
    public MessageSourceAccessor messageSourceAccessor(){
        ReloadableResourceBundleMessageSource messageSource = messageSource();
        return new MessageSourceAccessor(messageSource);
    }

    /**
     * Configuration StaticMessageSource
     *
     * @return
     */
    @Bean
    public StaticMessageSource staticMessageSource() {
        return new StaticMessageSource();
    }

    @Bean
    public MethodInvokingFactoryBean setStaticMessageSource() {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setTargetClass(StaticMessageSource.class);
        methodInvokingFactoryBean.setStaticMethod("com.study.toypro.core.utilities.StaticMessageSourceUtility.setMsgSrcAcs");

        Object[] args = {messageSourceAccessor()};
        methodInvokingFactoryBean.setArguments(args);
        return methodInvokingFactoryBean;
    }

}
