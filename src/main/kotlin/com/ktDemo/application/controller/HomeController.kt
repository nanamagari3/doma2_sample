package com.ktDemo.application.controller

import com.ktDemo.domain.repository.UsersRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
        private val usersRepository: UsersRepository
) {

    @GetMapping("")
    // fun hello():String = "hello"
    fun index(model: Model): String {
        val users = usersRepository.findAll()
        model.addAttribute("message", "Hello Kotlin!")
        model.addAttribute("users", users)
        return "home"
    }


}