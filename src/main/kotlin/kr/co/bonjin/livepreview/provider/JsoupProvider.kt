package kr.co.bonjin.livepreview.provider

import kr.co.bonjin.livepreview.model.PreviewModel
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service
import java.io.IOException
import java.util.*

@Service
class JsoupProvider {
    fun get(url: String): PreviewModel? {
        var headers = HashMap<String, String>()
        headers["accept-encoding"] = "gzip, deflate, br"
        headers["accept-language"] = "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7"
        val conn = Jsoup.connect(url)
                        .timeout(2*1000)
                        .headers(headers)
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