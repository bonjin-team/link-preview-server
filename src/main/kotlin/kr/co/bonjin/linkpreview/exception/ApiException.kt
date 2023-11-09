package kr.co.bonjin.linkpreview.exception

class ApiException(apiError: ApiError, message: String) : RuntimeException() {
    val code: String
    override val message: String

    companion object {
        private const val serialVersionUID = 1L
    }

    init {
        code = apiError.code
        this.message = apiError.message + message
    }
}