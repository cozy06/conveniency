package com.github.cozy06

import com.github.cozy06.Repeat.Companion.loop
import org.json.JSONObject
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

        fun File.insertLine(contents: String, index: Int) {
            val newContentsList = this.readFile().split("\n").toMutableList()
            newContentsList.add(index, contents)
            var newContents: String = ""
            loop({ newContents += newContentsList[it] + "\n" }, newContentsList.size)
            newContents = newContents.substring(0, newContents.length -2)
            val writer = FileWriter(path)
            try {
                writer.write(newContents)
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

        fun String.toJson(): JSONObject {
            return JSONObject(this)
        }
    }
}