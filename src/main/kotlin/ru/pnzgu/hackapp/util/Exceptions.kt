package ru.pnzgu.hackapp.util

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.NOT_FOUND)
class NotFoundException(message: String) : IllegalArgumentException(message)

@ResponseStatus(value = HttpStatus.CONFLICT)
class AlreadyExistsException(message: String) : IllegalArgumentException(message)

