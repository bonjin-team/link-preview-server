package kr.co.bonjin.livepreview.service

import kr.co.bonjin.livepreview.model.PreviewModel

interface CrawlingService {
    fun get(url: String): PreviewModel?
}