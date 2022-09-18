package me.muan.pubcast.core

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["me.muan.pubcast.core"])
class CoreApplication

fun main(args: Array<String>) {
	SpringApplication.run(CoreApplication::class.java, *args)
}
