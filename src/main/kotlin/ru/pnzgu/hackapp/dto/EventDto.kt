package ru.pnzgu.hackapp.dto

import java.time.Instant

data class EventDto(
    val eventid: Long,
    val eventname: String,
    val eventcase: String,
    var content: String,
    val author: String,
    val location: String,
    val date: Instant,
    var rating: Int? = null,
    var firstplace: String? = null,
    var secondplace: String? = null,
    var thirdplace: String? = null,
)

