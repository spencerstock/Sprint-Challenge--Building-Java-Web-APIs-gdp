package com.example.sprintchallengebuildingjavawebapisgdp.handler

import com.example.sprintchallengebuildingjavawebapisgdp.exception.ResourceNotFoundException
import com.example.sprintchallengebuildingjavawebapisgdp.models.ErrorDetail
import org.springframework.beans.TypeMismatchException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.NoHandlerFoundException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestController
@ControllerAdvice
class RestExceptionHandler: ResponseEntityExceptionHandler() {

    @Autowired
    private lateinit var messageSource: MessageSource

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(rnfe: ResourceNotFoundException,
                                        request: HttpServletRequest): ResponseEntity<*> {
        val errorDetail = ErrorDetail()
        errorDetail.setTimestamp(Date().time)
        errorDetail.status = HttpStatus.NOT_FOUND.value()
        errorDetail.title = "Resource Not Found"
        errorDetail.detail = rnfe.message
        errorDetail.developerMessage = rnfe.javaClass.name

        return ResponseEntity(errorDetail, null, HttpStatus.NOT_FOUND)
    }

    override fun handleTypeMismatch(ex: TypeMismatchException,
                                    headers: HttpHeaders, status: HttpStatus,
                                    request: WebRequest): ResponseEntity<Any> {

        val errorDetail = ErrorDetail()
        errorDetail.setTimestamp(Date().time)
        errorDetail.status = HttpStatus.BAD_REQUEST.value()
        errorDetail.title = ex.propertyName
        errorDetail.detail = ex.message
        errorDetail.developerMessage = request.getDescription(true)

        return ResponseEntity(errorDetail, HttpStatus.NOT_FOUND)
    }

    override fun handleNoHandlerFoundException(ex: NoHandlerFoundException,
                                               headers: HttpHeaders, status: HttpStatus,
                                               request: WebRequest): ResponseEntity<Any> {
        val errorDetail = ErrorDetail()
        errorDetail.setTimestamp(Date().time)
        errorDetail.status = HttpStatus.NOT_FOUND.value()
        errorDetail.title = ex.requestURL
        errorDetail.detail = request.getDescription(true)
        errorDetail.developerMessage = "Rest handler not found (check for valid URI"

        return ResponseEntity(errorDetail, null, HttpStatus.NOT_FOUND)
    }
}