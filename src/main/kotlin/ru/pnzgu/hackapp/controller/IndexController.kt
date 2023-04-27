package ru.pnzgu.hackapp.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.pnzgu.hackapp.service.EventService

@RestController
class IndexController(private val eventService : EventService) {

    @GetMapping("/api/getallevents", MediaType.APPLICATION_JSON_VALUE)
    fun getALlEventsApi() = eventService.getAllEvents()
}