package ru.pnzgu.hackapp.service

import org.springframework.stereotype.Service
import ru.pnzgu.hackapp.dto.EventDto
import ru.pnzgu.hackapp.dto.EventResultDto
import ru.pnzgu.hackapp.model.EventEntity
import ru.pnzgu.hackapp.repositories.EventRepository

@Service
class EventService(private val eventRepository: EventRepository) {
    fun getAllEvents() = eventRepository.findAll()

    fun findEventbyId(id: Long): List<EventEntity> {
        return eventRepository.findEventEntitiesByEventid(id)
    }

    fun ratingAdd(id: Long, rating: Int) {
        val list = eventRepository.findByEventid(id)
        list.rating = rating
        eventRepository.save(list)
    }

    fun createEvent(eventDto: EventDto): Long {
        return eventRepository.save(eventDto.toEntity()).eventid
    }

    private fun EventDto.toEntity(): EventEntity =
        EventEntity(
            eventid = 500,
            eventname = this.eventname,
            content = this.content,
            author = this.author,
            location = this.location,
            date = this.date
        )

    fun eventResult(id: Long, eventResultDto: EventResultDto): String {
        val event = eventRepository.findByEventid(id)
        event.firstplace = eventResultDto.firstPlace
        event.secondplace = eventResultDto.secondPlace
        event.thirdplace = eventResultDto.thirdPlace
        eventRepository.save(event)
        return "success"
    }
}