package ru.pnzgu.hackapp.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.pnzgu.hackapp.dto.UserAdditionalInfoDto
import ru.pnzgu.hackapp.dto.UserDto
import ru.pnzgu.hackapp.model.UserEntity
import ru.pnzgu.hackapp.repositories.UserRepository
import ru.pnzgu.hackapp.util.generateSnowflake

@Service
class UserService(private val userRepository: UserRepository, private val passwordEncoder: BCryptPasswordEncoder) {

    fun testPassword(password: String, encrypted: String): Boolean {
        return passwordEncoder.matches(password, encrypted)
    }

    fun processPassword(password: String): String {
        return passwordEncoder.encode(password)
    }

    fun findUserById(id: Long): List<UserEntity> {
        return userRepository.findUserEntitiesByUserid(id)
    }

    fun createUser(userDto: UserDto): Long {
        return userRepository.save(userDto.toEntity()).userid
    }

    private fun UserDto.toEntity(): UserEntity =
        UserEntity(
            userid = generateSnowflake(),
            password = this.password,
            email = this.email,
            role = this.role,
            surname = this.surname,
            username = this.username,
            lastname = this.lastname
        )

    fun registerUser(userDto: UserDto): Boolean {
        if (userDto.userid != null)
            return userRepository.findByIdOrNull(userDto.userid) != null

        val entity = UserEntity(
            userid = userDto.userid,
            password = userDto.password,
            email = userDto.email,
            role = userDto.role,
            surname = userDto.surname,
            username = userDto.username,
            lastname = userDto.lastname
        )
        return userRepository.runCatching { saveAndFlush(entity) }
            .isSuccess
    }

    fun lkconfirm(id: Long, userAdditionalInfoDto: UserAdditionalInfoDto) : String{
        val info = userRepository.findUserEntityByUserid(id)
        info.team = userAdditionalInfoDto.team
        info.passportserandnum = userAdditionalInfoDto.passportserandnum
        info.passportregloc = userAdditionalInfoDto.passportreqloc
        info.passportcreatedate = userAdditionalInfoDto.passportcreatedate
        info.passportcode = userAdditionalInfoDto.passportcode
        info.addresscountry = userAdditionalInfoDto.addresscountry
        info.addresscity = userAdditionalInfoDto.addresscity
        info.addressstreet = userAdditionalInfoDto.addressstreet
        info.addresshouse = userAdditionalInfoDto.addresshouse
        info.addressappartment = userAdditionalInfoDto.addressappartment
        userRepository.save(info)
        return "success"
    }

}