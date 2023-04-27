package ru.pnzgu.hackapp.service

import org.springframework.stereotype.Service
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
}