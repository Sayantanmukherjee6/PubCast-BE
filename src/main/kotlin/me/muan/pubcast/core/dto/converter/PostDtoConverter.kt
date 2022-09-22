package me.muan.pubcast.core.dto.converter

import me.muan.pubcast.core.document.Post
import me.muan.pubcast.core.dto.PostStreamDto
import org.springframework.stereotype.Component

@Component
class PostDtoConverter {

    fun convert(postEntity: Post): PostStreamDto {
        return PostStreamDto (
            postEntity.post,
            postEntity.email.toString(),
            postEntity.createdDate
        )
    }
}