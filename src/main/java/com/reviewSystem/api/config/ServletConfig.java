package com.reviewSystem.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebConfig.class)
public class ServletConfig {

}
