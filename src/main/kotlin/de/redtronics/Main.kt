package de.redtronics

import de.redtronics.database.Connect

fun main() {
    val connection = Connect().connect()
    println(connection)
}
