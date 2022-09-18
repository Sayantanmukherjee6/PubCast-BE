package me.muan.pubcast.core.controller

import me.muan.pubcast.core.dto.UserAddDto
import me.muan.pubcast.core.service.UserService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/user", produces = ["application/json"])
class UserController(
    private val userService: UserService
) {

    @PostMapping(value = ["/add"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addUser(
        @RequestBody body: UserAddDto
    ): ResponseEntity<String> {
        return userService.adduser(body)
    }
}