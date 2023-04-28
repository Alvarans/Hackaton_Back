package ru.pnzgu.hackapp.dto

import java.time.Instant

data class UserDto(
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
)
