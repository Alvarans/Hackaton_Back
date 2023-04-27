package ru.pnzgu.hackapp.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import ru.pnzgu.hackapp.dto.UserDto
import java.time.Instant

@Entity(name = "users")
data class UserEntity(
    @Id
    val userid: Long,
    val password: String,
    var email: String,
    val role: String,
    val surname: String,
    val username: String,
    val lastname: String,
    var rating: Int? = null,
    var team: String? = null,
    var passportserandnum: Long? = null,
    var passportregloc: String? = null,
    var passportcreatedate: Instant? = null,
    var passportcode: Int? = null,
    var addresscountry: String? = null,
    var addresscity: String? = null,
    var addressstreet: String? = null,
    var addresshouse: String? = null,
    var addressappartment: Int? = null,
) {
    fun toDto(): UserDto = UserDto(
        userid,
        password,
        email,
        role,
        surname,
        username,
        lastname,
        rating,
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