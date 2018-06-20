package com.beheresoft.security.configure;

import io.buji.pac4j.filter.SecurityFilter;
import lombok.Setter;
import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.core.client.Client;
import org.pac4j.core.config.Config;
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
    @Setter
    private CasClient client;

    @Bean
    public CasConfiguration casConfiguration(CasLogoutHandler casLogoutHandler) {
        if (cas == null) {
            cas = new CasConfiguration();
        }
        cas.setLogoutHandler(casLogoutHandler);
        return cas;
    }

    @Bean
    public SecurityFilter securityFilter(CasConfiguration casConfiguration) {
        SecurityFilter securityFilter = new SecurityFilter();
        securityFilter.setClients("cas");
        securityFilter.setConfig(casConfiguration);
        return new SecurityFilter();
    }

    @Bean
    public Config config(CasClient casClient) {
        Config config = new Config();
        return config;
    }

    @Bean
    public CasClient casClient(CasConfiguration config) {
        if (client == null) {
            client = new CasClient();
        }
        client.setConfiguration(config);
        return client;
    }

}
