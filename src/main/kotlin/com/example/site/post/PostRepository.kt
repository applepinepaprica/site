package com.example.site.post

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.Query

@Repository
interface PostRepository: ReactiveCrudRepository<Post, String> {
    @Query("{ id: { \$exists: true }}")
    fun findAllPaged(page: Pageable): Flux<Post>
}