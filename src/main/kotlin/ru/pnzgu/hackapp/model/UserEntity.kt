package ru.pnzgu.hackapp.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import ru.pnzgu.hackapp.dto.UserDto

@Entity(name="users")
class UserEntity(
    @Id
    val id: Long,
    val login: String,
    val password: String,
    var email: String,
    val role: String,
    var rating: Int,
    val results: Int,
    val surname: String,
    val username: String,
    val team: String,
) {
    fun toDto() : UserDto = UserDto(id, login, password, email, role, rating, results, surname, username, team)
}