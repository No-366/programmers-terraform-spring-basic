package com.back

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.s3.S3Client


@RestController
class HomeController(
    private val s3Client: S3Client // 추가해둔 의존성 -> S3 빈등록 가능 -> 빈으로 주입
) {
    @GetMapping
    fun main():String{
        return "Hello World!"
    }

    @GetMapping("/buckets")
    fun buckens(): List<String>{
        return s3Client.listBuckets().buckets().map{ it.name() }
    }
}