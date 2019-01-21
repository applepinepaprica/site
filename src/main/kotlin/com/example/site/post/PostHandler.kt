package com.example.site.post

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class PostHandler (private val postRepository: PostRepository) {

    fun showAllPosts(): Flux<Post> =
            postRepository.findAll()

    fun showPost(id: String): Mono<ResponseEntity<Post>> =
            postRepository.findById(id)
                    .map{ResponseEntity.ok(it)}
                    .defaultIfEmpty(ResponseEntity.notFound().build())

    fun addPost(post: Post): Mono<Post> =
            postRepository.save(post)

    fun updatePost(id: String, post: Post): Mono<ResponseEntity<Post>> =
        postRepository.findById(id)
                    .flatMap {postRepository.save(it.copy(title = post.title, text = post.text))}
                    .map{ResponseEntity.ok(it)}
                    .defaultIfEmpty(ResponseEntity.notFound().build())
}