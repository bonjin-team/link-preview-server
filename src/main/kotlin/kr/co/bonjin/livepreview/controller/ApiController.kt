package kr.co.bonjin.livepreview.controller

import kr.co.bonjin.livepreview.model.dto.PreviewRequestDto
import kr.co.bonjin.livepreview.response.ApiDataResponse
import kr.co.bonjin.livepreview.response.ApiResponse
import kr.co.bonjin.livepreview.service.CrawlingService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class ApiController(
    private val crawlingService: CrawlingService
) {

    @PostMapping(value = ["/", ""])
    fun get(@RequestBody dto: PreviewRequestDto): ApiResponse {
        val response = crawlingService.get(dto.url)
        return ApiDataResponse(response)
    }
}