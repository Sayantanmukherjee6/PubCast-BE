package me.muan.pubcast.core.repository

import me.muan.pubcast.core.document.User
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String>