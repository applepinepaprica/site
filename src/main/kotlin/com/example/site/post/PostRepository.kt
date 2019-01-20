package com.example.site.post

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : ReactiveCrudRepository<Post, String>