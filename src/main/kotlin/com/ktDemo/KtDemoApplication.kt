package com.ktDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtDemoApplication

fun main(args: Array<String>) {
    runApplication<KtDemoApplication>(*args)
}
