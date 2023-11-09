package kr.co.bonjin.livepreview.exception

import kr.co.bonjin.livepreview.response.ApiResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException::class)
    fun handleMemberException(e: RuntimeException): ApiResponse {

        if (e is ApiException) {
            val apiError = ApiError(e.code, e.message)
            return ApiResponse(apiError)
        }
        val internalServerError = ApiError.INTERNAL_SERVER_ERROR
        e.message?.let { message ->
            internalServerError.message = message
        }
        return ApiResponse(internalServerError)
    }
}