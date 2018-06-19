package com.beheresoft.security.configure;

import lombok.Setter;
import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.config.CasConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aladi
 */
@Configuration
@ConditionalOnProperty(value = "pac4j.cas.enable", havingValue = "true")
@ConditionalOnClass(CasConfiguration.class)
public class CasAutoConfiguration {

    @Setter
    private CasConfiguration cas;

    @Bean
    public CasConfiguration casConfiguration() {
        if (cas == null) {
            cas = new CasConfiguration();
        }
        return cas;
    }

    @Bean
    public CasClient casClient(CasConfiguration config) {
        return new CasClient(config);
    }

}
