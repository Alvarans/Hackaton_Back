package ru.pnzgu.hackapp.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.pnzgu.hackapp.model.EventEntity

@Repository
interface EventRepository : JpaRepository<EventEntity, Long> {
    fun findEventEntitiesByEventid(id: Long): List<EventEntity>
    fun findByEventid(id: Long): EventEntity

}