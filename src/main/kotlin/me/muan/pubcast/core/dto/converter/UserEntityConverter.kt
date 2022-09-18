package me.muan.pubcast.core.dto.converter

import me.muan.pubcast.core.document.User
import me.muan.pubcast.core.dto.UserAddDto
import org.bson.types.ObjectId
import org.springframework.stereotype.Component

@Component
class UserEntityConverter {

    fun convert(userAddDto: UserAddDto): User {
        return User (
            ObjectId.get(),
            userAddDto.name,
            userAddDto.userName,
            userAddDto.email
        )
    }
}