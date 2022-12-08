package de.redtronics.exam

import kotlin.random.Random
import de.redtronics.database.Select
import de.redtronics.docs.Office
import java.io.File
import java.io.FileOutputStream

class Generate {
    private val word = Office().wordDoc()

    fun generate() {
        var counter = 1

        while (counter < 6) {
            val ramNum = randomNumbers()
            println(ramNum)

            for (num in ramNum) {
                 val question = Select(
                    "SELECT * FROM questions WHERE SG=$counter AND FNR=$num"
                 ).select()
                println(question)

                Office().generateExam(question)
             }
            counter++
        }
        val out = FileOutputStream(File("test.docx"))
        this.word.write(out)
    }

    private fun randomNumbers(): MutableList<Int> {
        var counter = 0
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
