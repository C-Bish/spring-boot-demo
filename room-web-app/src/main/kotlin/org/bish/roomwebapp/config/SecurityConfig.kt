package org.bish.roomwebapp.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@Configuration
@EnableWebSecurity
class SecurityConfig {

    fun configure(http: HttpSecurity) {
        http.authorizeRequests()
    }
}