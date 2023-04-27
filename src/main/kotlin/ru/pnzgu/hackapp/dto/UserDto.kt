package ru.pnzgu.hackapp.dto

import java.time.Instant

data class UserDto(
    //reginfo
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
    var addressappartment: Int,
    var medpolisnum: Int? = null,

)
