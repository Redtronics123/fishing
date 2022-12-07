package de.redtronics.database

import java.sql.DriverManager
import java.sql.SQLException

class Connect {
    fun connect() {
        val url = "jdbc:sqlite:/home/nils/IdeaProjects/exam/src/main/resources/questions/brandenburg.db"

        try {
            DriverManager.getConnection(url)
            println("Connection successful")
        }
        catch (e: SQLException) {
            println(e.message)
        }
    }
}
