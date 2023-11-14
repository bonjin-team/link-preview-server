package kr.co.bonjin.linkpreview.controller

import kr.co.bonjin.linkpreview.model.dto.PreviewRequestDto
import kr.co.bonjin.linkpreview.response.ApiDataResponse
import kr.co.bonjin.linkpreview.response.ApiResponse
import kr.co.bonjin.linkpreview.service.CrawlingService
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["*"])
@RestController
class ApiController(
    private val crawlingService: CrawlingService
) {

    @GetMapping(value = ["/"])
    fun get(): ApiResponse {
        return ApiDataResponse("Get Request Success")
    }

    @PostMapping(value = ["/", "", "/api"])
    fun post(@RequestBody dto: PreviewRequestDto): ApiResponse {
        val response = crawlingService.get(dto.url)
        return ApiDataResponse(response)
    }

}