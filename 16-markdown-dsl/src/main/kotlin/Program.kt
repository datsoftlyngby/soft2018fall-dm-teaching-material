import dk.cphbusiness.markdown.dsl.markdown
import java.awt.SystemTray
import java.io.PrintWriter

fun main(args: Array<String>) {

    val doc = markdown {
        heading(1, "First heading")
        text("Some text to print")
        text("Some more text to print")
        }

    val output = PrintWriter(System.out, true)

    doc.printAsMarkdown(output)
    doc.printAsHtml(output)

    }