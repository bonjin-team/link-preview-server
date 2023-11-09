package kr.co.bonjin.linkpreview.exception

class ApiError(var code: String, var message: String) {
    companion object {
        val MISSING_PARAMETER = ApiError("1000", "Missing Require Parameter : ")
        val INVALID_PARAMETER = ApiError("1001", "Invalid Parameter : ")
        val INVALID_PATH = ApiError("2001", "Filename contains Invalid Path : ")
        val FILE_NOT_FOUND = ApiError("2002", "File not found : ")
        val INTERNAL_SERVER_ERROR = ApiError("9000", "Internal Server Error : ")
        val DEFAULT_ERROR = ApiError("9999", "")
    }
}