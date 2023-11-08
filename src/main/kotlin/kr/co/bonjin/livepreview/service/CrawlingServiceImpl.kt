package kr.co.bonjin.livepreview.service

import kr.co.bonjin.livepreview.model.PreviewModel
import kr.co.bonjin.livepreview.provider.JsoupProvider
import org.springframework.stereotype.Service

@Service
class CrawlingServiceImpl(
    private val jsoupProvider: JsoupProvider
): CrawlingService {

    override fun get(url: String): PreviewModel? {
        return jsoupProvider.get(url)
    }
}