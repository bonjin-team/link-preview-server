package kr.co.bonjin.linkpreview.service

import kr.co.bonjin.linkpreview.model.PreviewModel
import kr.co.bonjin.linkpreview.provider.JsoupProvider
import org.springframework.stereotype.Service

@Service
class CrawlingServiceImpl(
    private val jsoupProvider: JsoupProvider
): CrawlingService {

    override fun get(url: String): PreviewModel? {
        return jsoupProvider.get(url)
    }
}