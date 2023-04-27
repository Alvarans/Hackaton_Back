package ru.pnzgu.hackapp.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.pnzgu.hackapp.model.UserEntity

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findUserEntitiesByUserid(id: Long): List<UserEntity>

    fun findUserEntityByUserid(id: Long): UserEntity
    fun findUserEntitiesByUsername(username: String): UserEntity
}