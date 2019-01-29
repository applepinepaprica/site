package com.example.site.security

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

@Document
data class User(
        @Id val id: String? = null,
        private val username: String? = null,
        private val password: String? = null,
        val active: Boolean = true,
        val roles: List<String> = ArrayList()
): UserDetails {

    override fun getUsername() = username

    override fun getPassword() = password

    override fun isAccountNonExpired() = active

    override fun isAccountNonLocked()= active

    override fun isCredentialsNonExpired()= active

    override fun isEnabled()= active

    override fun getAuthorities(): Collection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(* roles.toTypedArray())
    }

}
