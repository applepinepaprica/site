package com.example.site.post

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class PostHandler (private val postRepository: PostRepository) {

    fun showPost(id: String): Mono<ResponseEntity<Post>> =
            postRepository.findById(id)
                    .map{ResponseEntity.ok(it)}
                    .defaultIfEmpty(ResponseEntity.notFound().build())

    fun addPost(post: Post): Mono<Post> =
            postRepository.save(post)
}