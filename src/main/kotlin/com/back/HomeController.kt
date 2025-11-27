package com.back

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HomeController(
    private val s3Service: S3Service // 추가해둔 의존성 -> S3 빈등록 가능 -> 빈으로 주입
) {

    @Value("\${custom.secretWord}")
    private val secretWord: String = ""

    @GetMapping
    fun main():String{
        return "Hello World!"
    }

    @GetMapping("/buckets")
    fun buckens(): List<String>{
        return s3Service.getBucketNames()
    }
}