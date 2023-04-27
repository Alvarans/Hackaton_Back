package ru.pnzgu.hackapp.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.pnzgu.hackapp.model.UserEntity

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findUserEntitiesById(id: Long): List<UserEntity>
    fun findUserEntitiesByUsername(username: String): UserEntity
}