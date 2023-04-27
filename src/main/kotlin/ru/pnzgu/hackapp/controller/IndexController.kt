package ru.pnzgu.hackapp.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.pnzgu.hackapp.dto.EventDto
import ru.pnzgu.hackapp.dto.EventResultDto
import ru.pnzgu.hackapp.model.EventEntity
import ru.pnzgu.hackapp.service.EventService

@RestController
class IndexController(private val eventService: EventService) {

    @GetMapping("/api/event/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getEventById(@PathVariable id: Long): List<EventDto> {
        return eventService.findEventbyId(id).map(EventEntity::toDto)
    }

    @GetMapping("/api/getallevents", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllEventsApi() = eventService.getAllEvents().map(EventEntity::toDto)


    @GetMapping("/api/changeeventrating/{id}")
    fun changeEventRating(@PathVariable id: Long) {
        eventService.ratingAdd(id, 2)
    }

    @PostMapping("/api/newevent", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createNewEvent(@RequestBody eventDto: EventDto): Long {
        return eventService.createEvent(eventDto)
    }

    @PostMapping("/api/eventresult/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putEventResult(@PathVariable id: Long, @RequestBody eventResultDto: EventResultDto): String {
        return eventService.eventResult(id, eventResultDto)
    }


}