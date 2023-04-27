package ru.pnzgu.hackapp.dto

import java.time.Instant

data class UserAdditionalInfoDto(
    val team: String,
    val passportserandnum: Long,
    val passportreqloc: String,
    val passportcreatedate: Instant,
    val passportcode: Int,
    val addresscountry: String,
    val addresscity: String,
    val addressstreet: String,
    val addresshouse: String,
    val addressappartment: Int
)
