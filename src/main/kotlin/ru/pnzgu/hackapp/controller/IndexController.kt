package ru.pnzgu.hackapp.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.pnzgu.hackapp.dto.EventDto
import ru.pnzgu.hackapp.dto.UserDto
import ru.pnzgu.hackapp.model.EventEntity
import ru.pnzgu.hackapp.model.UserEntity
import ru.pnzgu.hackapp.service.EventService
import ru.pnzgu.hackapp.service.UserService

@RestController
class IndexController(private val eventService: EventService, private val userService: UserService) {

    @GetMapping("/api/event/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getEventById(@PathVariable id: Long): List<EventDto> {
        return eventService.findEventbyId(id).map(EventEntity::toDto)
    }

    @GetMapping("/api/getallevents", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllEventsApi() = eventService.getAllEvents().map(EventEntity::toDto)

    @GetMapping("/api/user/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserById(@PathVariable id: Long): List<UserDto> {
        return userService.findUserById(id).map(UserEntity::toDto)
    }

    @GetMapping("/api/changeeventrating/{id}")
    fun changeEventRating(@PathVariable id : Long){
        eventService.ratingAdd(id, 2)
    }

    @PostMapping("/api/newevent", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createNewEvent(@RequestBody eventDto: EventDto) : Int{
        return eventService.createEvent(eventDto)
    }
}