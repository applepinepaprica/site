package com.example.site.post

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id

@Document
data class Post(@Id val id: String? = null,
               val title: String,
               val text: String)