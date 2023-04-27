package ru.pnzgu.hackapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class HackappApplication

fun main(args: Array<String>) {
    runApplication<HackappApplication>(*args)
}
