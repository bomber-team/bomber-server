package org.bomber.controllers.advicer

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackages = ["org.bomber"])
class ErrorAdvicer {
    private val logger = LoggerFactory.getLogger(ErrorAdvicer::class.java)

    @ExceptionHandler(Throwable::class)
    fun globalHandler(ex: Throwable) {
        logger.info("Get exception $ex")
    }
}