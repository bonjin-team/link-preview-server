package kr.co.bonjin.linkpreview.service

import kr.co.bonjin.linkpreview.model.PreviewModel

interface CrawlingService {
    fun get(url: String): PreviewModel?
}