package ru.pnzgu.hackapp.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import ru.pnzgu.hackapp.repositories.UserRepository
import ru.pnzgu.hackapp.util.NotFoundException

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails = SecurityUser(
            userRepository.findUserEntitiesByUsername(username)
                .orElseThrow { NotFoundException("User not found") })
}