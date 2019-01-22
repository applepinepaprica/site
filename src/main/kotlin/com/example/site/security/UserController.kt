package com.example.site.security

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RequestMapping("/")
@RestController
class UserController {

    @RequestMapping("/admin", method = [RequestMethod.GET])
    fun adminRequest(): Mono<ResponseEntity<Void>> =
            Mono.just(ResponseEntity(HttpStatus.OK))
}