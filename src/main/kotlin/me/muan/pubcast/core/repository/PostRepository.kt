package me.muan.pubcast.core.repository

import me.muan.pubcast.core.document.Post
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: MongoRepository<Post, String>