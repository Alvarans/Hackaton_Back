package ru.pnzgu.hackapp.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import ru.pnzgu.hackapp.dto.EventDto
import ru.pnzgu.hackapp.util.generateSnowflake
import java.time.Instant

@Entity(name = "events")
data class EventEntity(
    @Id
    val eventid: Long = generateSnowflake(),
    val eventname: String,
    var content: String,
    val author: String,
    val location: String,
    val date: Instant,
    var rating: Int? = null,
    var firstplace: String? = null,
    var secondplace: String? = null,
    var thirdplace: String? = null,
) {
    fun toDto(): EventDto =
        EventDto(eventid, eventname, content, author, location, date, rating, firstplace, secondplace, thirdplace)

}
