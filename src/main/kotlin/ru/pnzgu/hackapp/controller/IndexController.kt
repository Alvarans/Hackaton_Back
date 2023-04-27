package ru.pnzgu.hackapp.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.pnzgu.hackapp.dto.EventDto
import ru.pnzgu.hackapp.dto.EventResultDto
import ru.pnzgu.hackapp.dto.TeamDto
import ru.pnzgu.hackapp.model.EventEntity
import ru.pnzgu.hackapp.model.TeamEntity
import ru.pnzgu.hackapp.service.EventService
import ru.pnzgu.hackapp.service.TeamService

@RestController
class IndexController(private val eventService: EventService, private val teamService: TeamService) {

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

    @PostMapping("/api/chooseteam/", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun teamChoosing(teamDto: TeamDto) : List<TeamEntity>{
        TODO() //return teamService.choosingteam(teamDto).map(TeamEntity::toDto())
    }
}