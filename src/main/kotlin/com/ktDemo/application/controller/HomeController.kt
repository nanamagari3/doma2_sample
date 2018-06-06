package com.ktDemo.application.controller

import com.ktDemo.domain.repository.UsersRepository
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@RestController
@RequestMapping("/hello")
class HomeController(
        private val usersRepository: UsersRepository
) {

    @PostMapping("")
    fun hello(): String = "helloやで"

    @PostMapping("/dec/REQ_PARAM={JSON_PARAM}")
    fun getReqParam(@PathVariable("JSON_PARAM") request: String): String {

        return URLDecoder.decode(request, StandardCharsets.UTF_8.toString())

//        return if (request.lastName != null) {
//            "Hello %s %s".format(request.firstName, request.lastName)
//        } else {
//            "Hello %s".format(request.firstName)
//        }
    }

    @PostMapping("/enc/REQ_PARAM={JSON_PARAM}")
    fun encReqParam(@PathVariable("JSON_PARAM") request: String): String {

        return URLEncoder.encode(request, StandardCharsets.UTF_8.toString())
    }

}