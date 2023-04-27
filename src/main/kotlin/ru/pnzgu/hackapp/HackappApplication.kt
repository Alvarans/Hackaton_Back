package ru.pnzgu.hackapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HackappApplication

fun main(args: Array<String>) {
    runApplication<HackappApplication>(*args)
}
