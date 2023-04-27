package ru.pnzgu.hackapp.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.pnzgu.hackapp.model.TeamEntity
@Repository
interface TeamRepository : JpaRepository<TeamEntity,Long>{

    fun getTeamEntitiesByName(name: String) : List<TeamEntity>
}