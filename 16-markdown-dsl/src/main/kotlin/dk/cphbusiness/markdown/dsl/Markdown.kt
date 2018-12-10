package dk.cphbusiness.markdown.dsl

import java.io.PrintWriter

class Markdown : Content() {
    override fun printAsHtml(output: PrintWriter) {
        contents.forEach { it.printAsHtml(output) }
        }

    override fun printAsMarkdown(output: PrintWriter) {
        contents.forEach { it.printAsMarkdown(output) }
        }

    val contents = mutableListOf<Content>()

    fun heading(level: Int, title: String) {
        val heading = Heading(level, title)
        contents.add(heading)
        }

    fun text(value: String) {
        val text = Text(value)
        contents.add(text)
        }

    }

abstract class Content {
    abstract fun printAsMarkdown(output: PrintWriter)
    abstract fun printAsHtml(output: PrintWriter)
    }

class Text(val value: String): Content() {
    override fun printAsHtml(output: PrintWriter) {
        output.println("<p>$value</p>")
        }

    override fun printAsMarkdown(output: PrintWriter) {
        output.println(value)
        output.println()
        }
    }


class Heading(val level: Int, val title: String) : Content() {
    override fun printAsHtml(output: PrintWriter) {
        output.println("<h$level>$title</h$level>")
        }

    override fun printAsMarkdown(output: PrintWriter) {
        val marks = "#########".substring(0, level)
        output.println("$marks $title")
        output.println()
        }
    }

fun markdown(init: Markdown.() -> Unit): Markdown {
    val markdown = Markdown()
    markdown.init()
    return markdown
    }

