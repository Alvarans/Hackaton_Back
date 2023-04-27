package ru.pnzgu.hackapp.dto

data class UserDto(
    val id: Long,
    val login: String,
    val password: String,
    var email: String,
    val role: String,
    var rating: Int,
    val results: Int,
    val surname: String,
    val username: String
)
