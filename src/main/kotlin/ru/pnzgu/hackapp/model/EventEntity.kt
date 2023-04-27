package ru.pnzgu.hackapp.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.Instant

@Entity(name="events")
class EventEntity (
    @Id
    val eventid: Long,
    val eventname: String,
    var content: String,
    val author: String,
    val location: String,
    val date: Instant
) {}
