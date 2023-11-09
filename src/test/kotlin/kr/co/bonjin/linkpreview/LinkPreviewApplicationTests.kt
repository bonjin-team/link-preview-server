package kr.co.bonjin.linkpreview

import kr.co.bonjin.linkpreview.provider.JsoupProvider
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LinkPreviewApplicationTests(
    private val jsoupProvider: JsoupProvider
) {

    @Test
    fun contextLoads() {

        jsoupProvider.get("https://google.com")
    }

}
