package de.redtronics.database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class Connect {
    fun connect(): Connection? {
        var connection: Connection? = null
        val url = "jdbc:sqlite:/home/nils/IdeaProjects/exam/src/main/resources/questions/brandenburg.db"

        try {
            connection = DriverManager.getConnection(url)
            println("Connection successful")
        } catch (e: SQLException) {
            println(e.message)
        }
        return connection
    }
}
