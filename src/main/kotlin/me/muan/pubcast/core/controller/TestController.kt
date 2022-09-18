package me.muan.pubcast.core.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin("*")
@RequestMapping("/auth0")
class TestController {

    @GetMapping(value = ["/private"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun privateEndpoint(): ResponseEntity<String>? {
        return ResponseEntity.status(HttpStatus.OK).body("Private Endpoint Working fine !")
    }
}