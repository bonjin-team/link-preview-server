package kr.co.bonjin.livepreview.provider

import kr.co.bonjin.livepreview.model.PreviewModel
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class JsoupProvider {
    fun get(url: String): PreviewModel? {
        val conn = Jsoup.connect(url)
        try {
            val document = conn.get()

            return PreviewModel(
                document.select("meta[property=og:title]").attr("content"),
                document.select("meta[property=og:description]").attr("content"),
                document.select("meta[property=og:image]").attr("content"),
                document.select("meta[property=og:url]").attr("content")
            )
        } catch (error: IOException) {
            error.printStackTrace()
        }
        return null
    }
}