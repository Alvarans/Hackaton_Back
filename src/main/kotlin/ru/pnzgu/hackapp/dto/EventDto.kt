package ru.pnzgu.hackapp.dto

import java.time.Instant

data class EventDto(
    val eventname: String,
    var content: String,
    val author: String,
    val location: String,
    val date: Instant
)

