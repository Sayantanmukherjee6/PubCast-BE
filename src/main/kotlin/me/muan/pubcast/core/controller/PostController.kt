package me.muan.pubcast.core.controller

import me.muan.pubcast.core.dto.PostAddDto
import me.muan.pubcast.core.dto.PostStreamDto
import me.muan.pubcast.core.service.PostService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.codec.ServerSentEvent
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux


@CrossOrigin("*")
@RestController
@RequestMapping("/post", produces = ["application/json"])
class PostController(
    private val postService: PostService
) {

    @PostMapping(value = ["/add"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addPost(
        @RequestBody body: PostAddDto
    ): ResponseEntity<String> {
        return postService.addPost(body)
    }

    @GetMapping(value= ["/fetch"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun streamPosts(): Flux<ServerSentEvent<List<PostStreamDto>>> {
        return postService.streamPosts()
    }
}