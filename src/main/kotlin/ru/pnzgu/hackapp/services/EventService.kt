package ru.pnzgu.hackapp.services

import org.springframework.stereotype.Service
import ru.pnzgu.hackapp.repositories.EventRepository

@Service
class EventService(private val eventRepository: EventRepository) {
    fun getAllEvents() = eventRepository.findAll()
}