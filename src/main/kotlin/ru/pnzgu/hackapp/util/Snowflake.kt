package ru.pnzgu.hackapp.util

import java.time.Instant

const val TIMESTAMP_BITS = 15
var last_timestamp = snowflakeFromTimestamp(Instant.now())

fun snowflakeFromTimestamp(instant: Instant): Long =
    instant.toEpochMilli() shl TIMESTAMP_BITS

fun snowflakeAsTimestamp(snowflake: Long): Instant =
    Instant.ofEpochMilli(snowflake shr TIMESTAMP_BITS)

fun generateSnowflake(): Long {
    val newSnowflake = snowflakeFromTimestamp(Instant.now())
    if (newSnowflake <= last_timestamp) ++last_timestamp
    else last_timestamp = newSnowflake
    return last_timestamp
}