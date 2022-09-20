package me.muan.pubcast.core.service

import me.muan.pubcast.core.dto.PostAddDto
import me.muan.pubcast.core.dto.converter.PostEntityConverter
import me.muan.pubcast.core.repository.PostRepository
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
    private val postEntityConverter: PostEntityConverter
) {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    fun addPost(body: PostAddDto): ResponseEntity<String> {
        return try {
            logger.info("Post: ${body.post} is being posted by ${body.email}")
            postRepository.save(postEntityConverter.convert(body))
            ResponseEntity.status(HttpStatus.OK).body("Post Created by ${body.email}")
        } catch (exception: Exception) {
            logger.error("Exception =====>", exception)
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Problem saving post")
        }

    }
}