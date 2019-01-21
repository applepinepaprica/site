package com.example.site.post

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Document
data class Post(@Id val id: String? = null,
                @NotBlank @Size(max = 60) val title: String,
                @NotBlank @Size(max = 6000) val text: String,
                val createdAt: Date = Date())