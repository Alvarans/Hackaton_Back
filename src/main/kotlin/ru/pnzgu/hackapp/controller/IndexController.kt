package ru.pnzgu.hackapp.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.pnzgu.hackapp.dto.EventDto
import ru.pnzgu.hackapp.model.EventEntity
import ru.pnzgu.hackapp.service.EventService

@RestController
class IndexController(private val eventService: EventService) {

    @GetMapping("/api/eventbyid", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserById(@RequestBody id: Long): List<EventDto> {
        return eventService.getEventbyId(id).map(EventEntity::toDto)
    }
}