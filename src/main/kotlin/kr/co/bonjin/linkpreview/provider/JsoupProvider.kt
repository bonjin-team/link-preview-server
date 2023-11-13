package kr.co.bonjin.linkpreview.provider

import kr.co.bonjin.linkpreview.model.PreviewModel
import org.jsoup.Jsoup
import org.springframework.stereotype.Service
import java.io.IOException
import java.util.*

@Service
class JsoupProvider {
    fun get(url: String): PreviewModel? {

        var retryCount = 0
        var model: PreviewModel? = null

        while (retryCount < 3) {
            try {
                var headers = HashMap<String, String>()
                headers["accept-encoding"] = "gzip, deflate, br"
                headers["accept-language"] = "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7"
                val conn = Jsoup.connect(url)
                    .followRedirects(true)
                    .timeout(2*1000)
                    .headers(headers)
                val document = conn.get()

                val metaTags = document.select("meta[property^=og:]")
                if(metaTags.isEmpty()) {
                    retryCount++
                    continue
                }

                model = PreviewModel(
                    document.select("meta[property=og:title]").attr("content"),
                    document.select("meta[property=og:description]").attr("content"),
                    document.select("meta[property=og:image]").attr("content"),
                    document.select("meta[property=og:url]").attr("content")
                )
                break

            } catch (error: IOException) {
                error.printStackTrace()
            }
        }
        return model
    }
}