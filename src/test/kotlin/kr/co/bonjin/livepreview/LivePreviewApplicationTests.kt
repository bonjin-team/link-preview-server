package kr.co.bonjin.livepreview

import kr.co.bonjin.livepreview.provider.JsoupProvider
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LivePreviewApplicationTests(
    private val jsoupProvider: JsoupProvider
) {

    @Test
    fun contextLoads() {

        jsoupProvider.get("https://google.com")
    }

}
