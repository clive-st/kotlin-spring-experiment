package com.github.clives.delivery.rest.api.imp

import com.github.clives.delivery.rest.api.ErrorCodeDto
import com.github.clives.delivery.rest.api.ErrorDto
import com.github.clives.usecases.exceptions.MovieDetailsAccessException
import com.github.clives.usecases.exceptions.NotFoundException
import com.github.clives.usecases.exceptions.ValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@RestController
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(NotFoundException::class)
    fun notFound(ex: NotFoundException) =
            ResponseEntity(ErrorDto(ErrorCodeDto.NOT_FOUND, ex.message), HttpStatus.NOT_FOUND)

    @ExceptionHandler(ValidationException::class)
    fun alreadyExists(ex: ValidationException) =
            ResponseEntity(ErrorDto(ErrorCodeDto.VALIDATION_ERROR, ex.message), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(MovieDetailsAccessException::class)
    fun alreadyExists(ex: MovieDetailsAccessException) =
            ResponseEntity(ErrorDto(ErrorCodeDto.VALIDATION_ERROR, ex.message), HttpStatus.BAD_REQUEST)
}
