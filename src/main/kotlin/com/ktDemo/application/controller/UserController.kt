package com.ktDemo.application.controller

import com.ktDemo.application.request.SaveRequest
import com.ktDemo.domain.model.Users
import com.ktDemo.domain.repository.UsersRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
        private val usersRepository: UsersRepository
) {

    @GetMapping("")
    fun index(): List<Users> {
        val users = usersRepository.findAll()
        return users
    }

    @RequestMapping("/find")
    fun find(@RequestParam("id") id: Int): Users {
        return usersRepository.findById(id)
    }

    @RequestMapping("/regist")
    fun regist(@RequestBody request: SaveRequest): String {
        val registResult = usersRepository.regist(Users(id = request.id, firstName = request.firstName, lastName = request.lastName))
        return if (registResult > 0) {
            "OK"
        } else {
            "NG"
        }
    }

    @RequestMapping("/update")
    fun update(@RequestBody request: SaveRequest): String {
        val registResult = usersRepository.update(Users(id = request.id, firstName = request.firstName, lastName = request.lastName))
        return if (registResult > 0) {
            "OK"
        } else {
            "NG"
        }
    }

    @RequestMapping("/delete")
    fun delete(@RequestParam("id") id: Int): String {
        return if (usersRepository.delete(id) > 0) {
            "OK"
        } else {
            "NG"
        }
    }

}