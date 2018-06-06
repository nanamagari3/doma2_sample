package com.ktDemo.application.controller

import com.ktDemo.domain.repository.UsersRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
        private val usersRepository: UsersRepository
) {

    @GetMapping("")
    fun hello(): String = "hello"

}