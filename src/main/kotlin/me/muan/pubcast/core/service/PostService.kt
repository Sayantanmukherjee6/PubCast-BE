package me.muan.pubcast.core.service

import me.muan.pubcast.core.dto.PostAddDto
import me.muan.pubcast.core.dto.PostStreamDto
import me.muan.pubcast.core.dto.converter.PostDtoConverter
import me.muan.pubcast.core.dto.converter.PostEntityConverter
import me.muan.pubcast.core.repository.PostRepository
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.codec.ServerSentEvent
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration


@Service
class PostService(
    private val postRepository: PostRepository,
    private val postEntityConverter: PostEntityConverter,
    private val postDtoConverter: PostDtoConverter
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

    fun getAll(): List<PostStreamDto> {
        val allPost= postRepository.findAll()
         return allPost.map{eachPost -> postDtoConverter.convert(eachPost)}.sortedByDescending { it.createdDate }
    }

    fun streamPosts(): Flux<ServerSentEvent<List<PostStreamDto>>> {
        logger.info("Streaming posts")
        return Flux.interval(Duration.ofSeconds(2))
            .publishOn(Schedulers.boundedElastic())
            .map { sequence: Long ->
                ServerSentEvent.builder<List<PostStreamDto>>().id(sequence.toString())
                    .data(getAll())
                    .build()
            }
    }
}