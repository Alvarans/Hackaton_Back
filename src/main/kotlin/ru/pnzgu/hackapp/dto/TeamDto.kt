package ru.pnzgu.hackapp.dto

data class TeamDto(
    val teamid: Long,
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


