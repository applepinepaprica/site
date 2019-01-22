package com.example.site.security

import org.springframework.context.support.beans
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

fun beans() = beans {

    bean<SecurityWebFilterChain> {
        ref<ServerHttpSecurity>().authorizeExchange()
                .pathMatchers("/admin")
                .hasAuthority("ROLE_ADMIN")
                .anyExchange()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .build()
    }

    bean<PasswordEncoder> {
        BCryptPasswordEncoder()
    }

    bean {
        ReactiveUserDetailsService { username ->
            ref<UserRepository>()
                    .findByUsername(username)
                    .cast(UserDetails::class.java)
        }
    }
}