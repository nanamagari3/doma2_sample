package com.ktDemo.application.controller

import com.ktDemo.application.request.SaveRequest
import com.ktDemo.domain.model.Users
import com.ktDemo.domain.service.UsersService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
        private val usersService: UsersService
) {

    @GetMapping("")
    fun index(): List<Users> {
        val users = usersService.findAll()
        return users
    }

    @RequestMapping("/find")
    fun find(@RequestParam("id") id: Int): Users {
        return usersService.findById(id)
    }

    @RequestMapping("/regist")
    fun regist(@RequestBody request: SaveRequest): Users {
        return usersService.regist(Users(id = request.id, firstName = request.firstName, lastName = request.lastName))
    }

    @RequestMapping("/update")
    fun update(@RequestBody request: SaveRequest): Int {
        return usersService.update(Users(id = request.id, firstName = request.firstName, lastName = request.lastName))

    }

    @RequestMapping("/delete")
    fun delete(@RequestParam("id") id: Int): Int {
        return usersService.delete(id)
    }
}