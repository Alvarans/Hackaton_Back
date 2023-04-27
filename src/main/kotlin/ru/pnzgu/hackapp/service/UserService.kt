package ru.pnzgu.hackapp.service

import org.springframework.stereotype.Service
import ru.pnzgu.hackapp.model.UserEntity
import ru.pnzgu.hackapp.repositories.UserRepository

@Service
class UserService (private val userRepository: UserRepository){

    fun findUserById( id: Long) : List<UserEntity>{
        return userRepository.findUserEntitiesById(id)
    }
}