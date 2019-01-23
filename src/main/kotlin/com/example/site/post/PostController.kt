package com.example.site.post

import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid

@RequestMapping("/controller")
@RestController
class PostController(private val postHandler: PostHandler) {

    @RequestMapping("/posts", method = [RequestMethod.GET])
    fun showAllPosts(@RequestParam(name = "page", defaultValue = "0") page: Int,
                     @RequestParam(name = "size", defaultValue = "20") size: Int): Flux<Post> =
            postHandler.showAllPosts(PageRequest.of(page, size))

    @RequestMapping("/post/{id}", method = [RequestMethod.GET])
    fun showPost(@PathVariable id: String): Mono<ResponseEntity<Post>> =
            postHandler.showPost(id)

    @RequestMapping("/post", method = [RequestMethod.POST])
    fun addPost(@Valid @RequestBody post: Post): Mono<Post> =
            postHandler.addPost(post)

    @RequestMapping("/post/{id}", method = [RequestMethod.PUT])
    fun updatePost(@PathVariable id: String,
                   @Valid @RequestBody post: Post): Mono<ResponseEntity<Post>> =
            postHandler.updatePost(id, post)

    @RequestMapping("/post/{id}", method = [RequestMethod.DELETE])
    fun deletePost(@PathVariable id: String): Mono<ResponseEntity<Void>> =
            postHandler.deletePost(id)
}