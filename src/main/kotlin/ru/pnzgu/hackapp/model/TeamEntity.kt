package ru.pnzgu.hackapp.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import ru.pnzgu.hackapp.dto.EventDto
import ru.pnzgu.hackapp.dto.TeamDto

@Entity(name = "teams")
data class TeamEntity(
    @Id val teamid: Long,
    val name: Long,
    val description: String,
    val skills: String,
    val firstmember: String,
    val secondmember: String,
    val thirdmember: String,
    val fourthmember: String,
    val fifthmember: String
)
{
    fun toDto(): TeamDto =
        TeamDto(teamid, name, description, skills, firstmember, secondmember, thirdmember, fourthmember, fifthmember)
}