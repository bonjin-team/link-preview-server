package kr.co.bonjin.livepreview.response

import kr.co.bonjin.livepreview.exception.ApiError

open class ApiResponse {
    //공통적으로 갖고 있는것
    var status: String
    private var error: ApiError

    constructor() {
        status = "OK"
        error = ApiError("", "")
    }

    constructor(error: ApiError) {
        status = "Failed"
        this.error = error
    }

    fun getError(): ApiError {
        return error
    }

    fun setError(error: ApiError) {
        this.error = error
    }
}
