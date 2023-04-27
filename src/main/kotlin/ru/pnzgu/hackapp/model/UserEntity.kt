package ru.pnzgu.hackapp.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import ru.pnzgu.hackapp.dto.UserDto
import java.time.Instant

@Entity(name = "users")
data class UserEntity(
    @Id
    val id: Long,
    val password: String,
    var email: String,
    val role: String,
    var rating: Int? = null,
    val results: Int? = null,
    val surname: String,
    val username: String,
    var team: String? = null,
    var passportserandnum: Int? = null,
    var passportregloc: String? = null,
    var passportcreatedate: Instant? = null,
    var passportcode: Int? = null,
    var addresscountry: String? = null,
    var addresscity: String? = null,
    var addressstreet: String? = null,
    var addresshouse: String? = null,
    var addressappartment: Int? = null,
    var medpolisnum: Int? = null,
) {
    fun toDto(): UserDto = UserDto(
        id,
        password,
        email,
        role,
        rating,
        results,
        surname,
        username,
        team,
        passportserandnum,
        passportregloc,
        passportcreatedate,
        passportcode,
        addresscountry,
        addresscity,
        addressstreet,
        addresshouse,
        addressappartment
    )
}