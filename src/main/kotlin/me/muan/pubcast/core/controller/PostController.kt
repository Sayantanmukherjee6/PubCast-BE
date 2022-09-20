package me.muan.pubcast.core.controller

import me.muan.pubcast.core.dto.PostAddDto
import me.muan.pubcast.core.dto.UserAddDto
import me.muan.pubcast.core.service.PostService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
}