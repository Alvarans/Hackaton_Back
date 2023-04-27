package ru.pnzgu.hackapp.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

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
}