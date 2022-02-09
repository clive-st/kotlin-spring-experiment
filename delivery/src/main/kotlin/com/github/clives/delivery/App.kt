package com.github.clives.delivery

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = [
    "com.github.clives.delivery.config",
    "com.github.clives.dataproviders.db.jpa.config",
    "com.github.clives.delivery.rest.api.imp",
    "com.github.clives.dataproviders.restclient",
    "com.github.clives.delivery.rest.imp"
])
class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}
