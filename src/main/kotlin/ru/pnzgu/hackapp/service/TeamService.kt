package ru.pnzgu.hackapp.service

import org.springframework.stereotype.Service
import ru.pnzgu.hackapp.dto.TeamDto
import ru.pnzgu.hackapp.model.TeamEntity
import ru.pnzgu.hackapp.repositories.TeamRepository

@Service
class TeamService(private val teamRepository: TeamRepository) {
    fun choosingTeam(name : String) : List<TeamEntity>{
        return teamRepository.getTeamEntitiesByName(name)
    }
}