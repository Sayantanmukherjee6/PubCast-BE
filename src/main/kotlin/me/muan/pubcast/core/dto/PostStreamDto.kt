package me.muan.pubcast.core.dto

import java.time.LocalDateTime

data class PostStreamDto(
    val post: String,
    val email: String,
    val createdDate: LocalDateTime
)
