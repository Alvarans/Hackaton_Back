package ru.pnzgu.hackapp.service

import org.springframework.stereotype.Service
import ru.pnzgu.hackapp.model.UserEntity
import ru.pnzgu.hackapp.repositories.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {

    fun findUserById(id: Long): List<UserEntity> {
        return userRepository.findUserEntitiesById(id)
    }
    /*
        fun registerUser(userDto: UserDto): Boolean {
            if (userDto.id != null)
                return userRepository.findByIdOrNull(userDto.id) != null

            val entity = UserEntity(id = userDto.id, login = userDto.login, password = userDto.password, email = userDto.password, role = userDto.role, rating = userDto.rating, results = userDto.results, surname = userDto.surname, username = userDto.username, team = userDto.team)
            return userRepository.runCatching { saveAndFlush(entity) }
                .isSuccess
        }
        */
}