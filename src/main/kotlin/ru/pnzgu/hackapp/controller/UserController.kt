package ru.pnzgu.hackapp.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.pnzgu.hackapp.dto.UserAdditionalInfoDto
import ru.pnzgu.hackapp.dto.UserDto
import ru.pnzgu.hackapp.dto.UserLoginDto
import ru.pnzgu.hackapp.model.UserEntity
import ru.pnzgu.hackapp.service.UserService
import ru.pnzgu.hackapp.util.AlreadyExistsException

@RestController
class UserController(private val userService: UserService) {
    @GetMapping("/api/user/{id}", MediaType.APPLICATION_JSON_VALUE)
    fun getUserById(@PathVariable id: Long) =
        userService.findUserById(id).map(UserEntity::toDto)

    @PostMapping("/api/user", MediaType.APPLICATION_JSON_VALUE)
    fun collectUser(@RequestBody userData: UserDto): String {
        if (userService.createUser(userData) == 0L)
            throw AlreadyExistsException("User with this id already exists")
        return "success"
    }

    @PostMapping("/api/newuser", MediaType.APPLICATION_JSON_VALUE)
    fun createNewUser(@RequestBody userDto: UserDto) = userService.createUser(userDto)

    @PostMapping("/api/lkinfoconfirm/{id}", MediaType.APPLICATION_JSON_VALUE)
    fun lkinfoconfirm(@PathVariable id: Long, @RequestBody userAdditionalInfoDto: UserAdditionalInfoDto) =
        userService.lkconfirm(id, userAdditionalInfoDto)

    @PostMapping("/api/login", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun authorizeMaket(@RequestBody userLoginDto: UserLoginDto): Long? {
        return userService.userLogin(userLoginDto)
    }

    @DeleteMapping("/api/deleteuser/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.deleteUser(id)
    }

}