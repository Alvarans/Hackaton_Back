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
class IndexController(
    private val eventService: EventService,
    private val teamService: TeamService
) {

    @GetMapping("/api/event/{id}", MediaType.APPLICATION_JSON_VALUE)
    fun getEventById(@PathVariable id: Long) =
        eventService.findEventbyId(id).map(EventEntity::toDto)

    @GetMapping("/api/getallevents", MediaType.APPLICATION_JSON_VALUE)
    fun getAllEventsApi() = eventService.getAllEvents().map(EventEntity::toDto)

    @GetMapping("/api/changeeventrating/{id}")
    fun changeEventRating(@PathVariable id: Long) = eventService.ratingAdd(id, 2)

    @PostMapping("/api/newevent", MediaType.APPLICATION_JSON_VALUE)
    fun createNewEvent(@RequestBody eventDto: EventDto) = eventService.createEvent(eventDto)

    @PostMapping("/api/eventresult/{id}", MediaType.APPLICATION_JSON_VALUE)
    fun putEventResult(@PathVariable id: Long, @RequestBody eventResultDto: EventResultDto) =
        eventService.eventResult(id, eventResultDto)

    @GetMapping("/api/team/{name}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun teamChoosing(@PathVariable name : String) : List<TeamDto> {
        return teamService.choosingTeam(name).map(TeamEntity::toDto)
    }
/*
    @GetMapping("/api/userteam/{name}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun userTeams(@PathVariable name: String)  : List<TeamDto> {
        return teamService.teams(name).map(TeamEntity::toDto)
    }
    */

    @PostMapping("/api/newteam", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createNewTeam(teamDto: TeamDto) : Long {
        return teamService.createTeam(teamDto)
    }
}