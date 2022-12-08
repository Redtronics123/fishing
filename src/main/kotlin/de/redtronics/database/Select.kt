package de.redtronics.database

class Select(private val sqlQueryCommand: String) {
    private val question = mutableListOf<String>()
    fun select(): MutableList<String> {
        val connection = Connect().connect()

        val state = connection?.createStatement()

        val res = state?.executeQuery(sqlQueryCommand)

        this.question.add(res?.getString("Frage").toString())
        this.question.add(res?.getString("AntwortA").toString())
        this.question.add(res?.getString("AntwortB").toString())
        this.question.add(res?.getString("AntwortC").toString())

        return question
    }
}