package ru.pnzgu.hackapp.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import ru.pnzgu.hackapp.dto.EventDto
import ru.pnzgu.hackapp.dto.TeamDto

@Entity(name = "teams")
data class TeamEntity(
    @Id val teamid: Long,
    val name: String,
    val description: String,
    val skills: String,
    val firstmember: String,
    val firstmemberrole: String,
    val secondmember: String? = null,
    val secondmemberrole: String? = null,
    val thirdmember: String? = null,
    val thirdmemberrole: String? = null,
    val fourthmember: String? = null,
    val fourthmemberrole: String? = null,
    val fifthmember: String? = null,
    val fifthmemberrole: String? = null,
    val lider: String? = null
)
{
    fun toDto(): TeamDto =
        TeamDto(teamid, name, description, skills, firstmember, firstmemberrole, secondmember, secondmemberrole, thirdmember, thirdmemberrole, fourthmember, fourthmemberrole, lider)
}