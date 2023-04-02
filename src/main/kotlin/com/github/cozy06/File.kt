package com.github.cozy06

import java.io.File
import java.io.FileWriter
import java.io.InputStream

class File {
    companion object {
        fun File.readFile(): String {
            if(this.exists()) {
                val inputStream: InputStream = this.inputStream()
                return inputStream.bufferedReader().use { it.readText() }
            }
            else {
                throw IllegalArgumentException("No File Path ${this.path}")
            }
        }

        fun File.writeAll(contents: String) {
            val writer = FileWriter(path)
            try {
                writer.write(contents)
            } catch (e:Exception) {
                e.printStackTrace()
            } finally {
                writer.close()
            }
        }

        fun File.addLine(contents: String) {
            val newContents: String = this.readFile() + "\n" + contents
            val writer = FileWriter(path)
            try {
                writer.write(newContents)
            } catch (e:Exception) {
                e.printStackTrace()
            } finally {
                writer.close()
            }
        }
    }
}