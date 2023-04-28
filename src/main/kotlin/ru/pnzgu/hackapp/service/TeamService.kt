package ru.pnzgu.hackapp.service

import org.springframework.stereotype.Service
import ru.pnzgu.hackapp.dto.TeamDto
import ru.pnzgu.hackapp.model.TeamEntity
import ru.pnzgu.hackapp.repositories.TeamRepository
import ru.pnzgu.hackapp.util.generateSnowflake

@Service
class TeamService(private val teamRepository: TeamRepository) {
    fun choosingTeam(name : String) : List<TeamEntity>{
        return teamRepository.getTeamEntitiesByName(name)
    }

    fun createTeam(teamDto: TeamDto):Long{
        return teamRepository.save(teamDto.toEntity()).teamid
    }
    /*
    fun teams(name: String) : List<TeamEntity>{
        return teamRepository.findTeamEntitiesByFirstmemberOrSecondmemberOrThirdmemberOrFourthmemberOrFifthmember(name)
    } */

    private fun TeamDto.toEntity(): TeamEntity = TeamEntity(
        teamid = generateSnowflake(),
        name = this.name,
        description = this.description,
        skills = this.skills,
        firstmember = this.firstmember,
        firstmemberrole = this.firstmemberrole,
        secondmember = this.secondmember,
        secondmemberrole = this.secondmemberrole,
        thirdmember = this.thirdmember,
        thirdmemberrole = this.thirdmemberrole,
        fourthmember = this.fourthmember,
        fourthmemberrole = this.fourthmemberrole,
        fifthmember = this.fifthmember,
        fifthmemberrole = this.fifthmemberrole,
        lider = this.lider
    )

}