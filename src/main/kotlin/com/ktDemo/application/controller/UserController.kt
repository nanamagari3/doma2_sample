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
    fun regist(@RequestBody request: SaveRequest): String {
        val registResult = usersService.regist(Users(id = request.id, firstName = request.firstName, lastName = request.lastName))
        return if (registResult > 0) {
            "OK"
        } else {
            "NG"
        }
    }

    @RequestMapping("/update")
    fun update(@RequestBody request: SaveRequest): Users {
        val registResult = usersService.update(Users(id = request.id, firstName = request.firstName, lastName = request.lastName))
        return registResult
    }

    @RequestMapping("/delete")
    fun delete(@RequestParam("id") id: Int): String {
        return if (usersService.delete(id) > 0) {
            "OK"
        } else {
            "NG"
        }
    }

}