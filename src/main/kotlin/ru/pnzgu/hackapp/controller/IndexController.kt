package ru.pnzgu.hackapp.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.pnzgu.hackapp.dto.EventDto
import ru.pnzgu.hackapp.dto.UserDto
import ru.pnzgu.hackapp.model.EventEntity
import ru.pnzgu.hackapp.model.UserEntity
import ru.pnzgu.hackapp.service.EventService
import ru.pnzgu.hackapp.service.UserService
import javax.print.attribute.standard.Media

@RestController
class IndexController(private val eventService: EventService, private val userService: UserService) {

    @GetMapping("/api/event/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getEventById(@PathVariable id: Long): List<EventDto> {
        return eventService.getEventbyId(id).map(EventEntity::toDto)
    }
    @GetMapping("/api/getallevents", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllEventsApi() = eventService.getAllEvents().map(EventEntity::toDto)

    @GetMapping("/api/user/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserById(@PathVariable id: Long): List<UserDto>{
        return userService.findUserById(id).map(UserEntity::toDto)
    }
}