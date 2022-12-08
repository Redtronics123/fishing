package de.redtronics.docs

import java.io.File
import java.io.FileOutputStream
import org.apache.poi.xwpf.usermodel.XWPFDocument

class Office(private val path: String) {
    fun wordDoc(): XWPFDocument {
        val doc = XWPFDocument()
        val out: FileOutputStream = FileOutputStream(File("test.docx"))

        doc.write(out)

        return doc
    }
}
