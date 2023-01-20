package fr.esgi.project
package io

import java.io.PrintWriter

object Write {
    def writeFile(path: String, data: String): Unit = {
        new PrintWriter(path) {
            write(data); close()
        }
    }
}
