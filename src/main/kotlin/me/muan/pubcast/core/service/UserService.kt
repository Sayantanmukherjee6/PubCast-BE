package me.muan.pubcast.core.service

import me.muan.pubcast.core.document.User
import me.muan.pubcast.core.dto.UserAddDto
import me.muan.pubcast.core.dto.converter.UserEntityConverter
import me.muan.pubcast.core.repository.UserRepository
import mu.KotlinLogging
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userEntityConverter: UserEntityConverter,
    private val mongoTemplate: MongoTemplate
) {

    companion object {
        private val logger = KotlinLogging.logger {}
    }

    fun adduser(body: UserAddDto): ResponseEntity<String> {
        return try{
            val query = Query()
            query.addCriteria(Criteria.where("email").`is`(body.email))
            val result= mongoTemplate.findOne(query,User::class.java)
            if(result == null) {
                logger.error("Adding ${body.userName} to DB")
                userRepository.save(userEntityConverter.convert(body))
            }
            ResponseEntity.status(HttpStatus.OK).body("User Created")
        } catch (exception: Exception) {
            logger.error("Exception =====>", exception)
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Problem saving user")
        }
    }
}