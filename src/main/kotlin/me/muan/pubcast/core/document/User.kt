package me.muan.pubcast.core.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document("user")
data class User(
    @Id
    val id: ObjectId,
    @Field(name="full_name")
    var name: String,
    @Field(name="user_name")
    var userName: String,
    @Field(name="email")
    @Indexed(unique = true)
    var email: String?= null,
    @Field(name="created")
    val createdDate: LocalDateTime = LocalDateTime.now()
)
