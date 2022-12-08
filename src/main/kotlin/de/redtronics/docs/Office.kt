package de.redtronics.docs

import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun

class Office {
    private val doc = XWPFDocument()
    private val title: XWPFParagraph = doc.createParagraph()
    private val titleRun: XWPFRun = title.createRun()
    private val table = doc.createTable()
    private val tableRow = table.getRow(0)

    fun wordDoc(): XWPFDocument {

        this.titleRun.setText("Fischereischeinprüfung")
        this.titleRun.fontSize = 20
        this.titleRun.fontFamily = "Arial"

        this.tableRow.getCell(0).text = "Fragen"
        this.tableRow.addNewTableCell().text = "Antwort 1"
        this.tableRow.addNewTableCell().text = "Antwort 2"
        this.tableRow.addNewTableCell().text = "Antwort 3"

        return doc
    }
    fun generateExam(question: MutableList<String>) {
        val tableRows = this.table.createRow()

        tableRows.getCell(0).text = question[0]
        tableRows.getCell(1).text = question[1]
        tableRows.getCell(2).text = question[2]
        tableRows.getCell(3).text = question[3]

    }
}
