package com.example.site.post

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.Valid

@RequestMapping("/controller")
@RestController
class PostController(private val postHandler: PostHandler) {

    @RequestMapping("/post/{id}", method = [RequestMethod.GET])
    fun showPost(@PathVariable id: String): Mono<ResponseEntity<Post>> =
            postHandler.showPost(id)

    @RequestMapping("/post", method = [RequestMethod.POST])
    fun addPost(@Valid @RequestBody post: Post): Mono<Post> =
            postHandler.addPost(post)
}