package de.redtronics.exam

import kotlin.random.Random
import de.redtronics.database.Select
import de.redtronics.docs.Office

class Generate {
    fun generate() {
        var word = Office("/").wordDoc()


        var counter: Int = 1

        while (counter < 6) {
            val ramNum = randomNumbers()

            for (num in ramNum) {
                 var question = Select(
                    "SELECT Frage, Antwort1, Antwort2, Antwort3 FROM questions WHERE SG=$counter WHERE FNR=$num"
                 ).select()
                println("Here in docx: $question")

             }
            counter++
        }
    }

    private fun randomNumbers(): MutableList<Int> {
        var counter: Int = 0
        val nums = mutableListOf<Int>()

        while (counter < 12) {
            val randomNum = Random.nextInt(1, 121)

            if (randomNum in nums) {
                continue
            }
            nums.add(randomNum)
            counter++
        }
        return nums
    }

}
