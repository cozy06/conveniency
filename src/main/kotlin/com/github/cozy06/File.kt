package com.github.cozy06

import com.github.cozy06.Logic.Companion.loop
import org.json.JSONObject
import java.io.File
import java.io.FileWriter
import java.io.InputStream


class File {
    companion object {
        /**
         * 파일 읽기
         * @return String형식 파일 내용
         */
        fun File.readFile(): String {
            if(this.exists()) {
                val inputStream: InputStream = this.inputStream()
                return inputStream.bufferedReader().use { it.readText() }
            }
            else {
                throw IllegalArgumentException("No File Path ${this.path}")
            }
        }

        /**
         * 파일 작성
         * @param contents 입력 내용
         */
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

        /**
         * 파일 내용 삽입
         * @param contents 입력 내용
         * @param index 삽입 위치
         */
        fun File.insertLine(contents: String, index: Int) {
            val newContentsList = this.readFile().split("\n").toMutableList()
            newContentsList.add(index, contents)
            var newContents: String = ""
            repeat(newContentsList.size) { newContents += newContentsList[it] + "\n" }
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

        /**
         * 파일 마지막줄에 추가
         * @param contents 입력 내용
         */
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

        /**
         * 문자열을 json형식으로 바꾸기
         * org.json:json:<version> 의존
         * @return JSONObject
         */
        fun String.toJson(): JSONObject {
            return JSONObject(this)
        }
    }
}