package me.muan.pubcast.core.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document("post")
data class Post(
    @Id
    val id: ObjectId,
    @Field(name="post")
    var post: String,
    @Field(name="email")
    var email: String?= null,
    @Field(name="created")
    val createdDate: LocalDateTime = LocalDateTime.now()
)
