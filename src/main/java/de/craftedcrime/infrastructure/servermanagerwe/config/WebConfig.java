package de.craftedcrime.infrastructure.servermanagerwe.config;
/*
 * Created by ian on 27.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.config
 * Created for the project servermanagerwe with the name WebConfig
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
}
