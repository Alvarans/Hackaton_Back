package ru.pnzgu.hackapp.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.pnzgu.hackapp.dto.UserAdditionalInfoDto
import ru.pnzgu.hackapp.dto.UserDto
import ru.pnzgu.hackapp.model.UserEntity
import ru.pnzgu.hackapp.service.UserService
import ru.pnzgu.hackapp.util.AlreadyExistsException

@RestController
class UserController(private val userService: UserService) {
    @GetMapping("/api/user/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserById(@PathVariable id: Long): List<UserDto> {
        return userService.findUserById(id).map(UserEntity::toDto)
    }

    @PostMapping("/api/user", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun collectUser(@RequestBody userData: UserDto): String {
        val successful = userService.registerUser(userData)
        if (!successful)
            throw AlreadyExistsException("User with this id already exists")
        return "success"
    }

    @PostMapping("/api/newuser", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createNewUser(@RequestBody userDto: UserDto): Long {
        return userService.createUser(userDto)
    }

    @PostMapping("/api/lkinfoconfirm/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun lkinfoconfirm(@PathVariable id: Long, @RequestBody userAdditionalInfoDto: UserAdditionalInfoDto):String{
        return userService.lkconfirm(id,userAdditionalInfoDto)
    }
}