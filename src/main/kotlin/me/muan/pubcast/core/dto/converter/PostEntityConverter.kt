package me.muan.pubcast.core.dto.converter

import me.muan.pubcast.core.document.Post
import me.muan.pubcast.core.document.User
import me.muan.pubcast.core.dto.PostAddDto
import org.bson.types.ObjectId
import org.springframework.stereotype.Component

@Component
class PostEntityConverter {

    fun convert(postAddDto: PostAddDto): Post {
        return Post (
            ObjectId.get(),
            postAddDto.post,
            postAddDto.email
        )
    }
}