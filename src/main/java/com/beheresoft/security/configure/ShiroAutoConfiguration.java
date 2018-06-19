package com.beheresoft.security.configure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "shiro.enable", havingValue = "true")
public class ShiroAutoConfiguration {



}
