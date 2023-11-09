package kr.co.bonjin.linkpreview.controller

import kr.co.bonjin.linkpreview.model.dto.PreviewRequestDto
import kr.co.bonjin.linkpreview.response.ApiDataResponse
import kr.co.bonjin.linkpreview.response.ApiResponse
import kr.co.bonjin.linkpreview.service.CrawlingService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(origins = ["*"])
@RestController
class ApiController(
    private val crawlingService: CrawlingService
) {

    @PostMapping(value = ["/", "", "/api"])
    fun get(@RequestBody dto: PreviewRequestDto): ApiResponse {
        val response = crawlingService.get(dto.url)
        return ApiDataResponse(response)
    }
}