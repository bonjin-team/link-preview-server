package kr.co.bonjin.livepreview

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LivePreviewApplication

fun main(args: Array<String>) {
    runApplication<LivePreviewApplication>(*args)
}
