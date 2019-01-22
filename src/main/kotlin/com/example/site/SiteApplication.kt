package com.example.site

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.example.site.security.beans

@SpringBootApplication
class SiteApplication

fun main(args: Array<String>) {
	runApplication<SiteApplication>(*args) {
		addInitializers(beans())
	}
}

