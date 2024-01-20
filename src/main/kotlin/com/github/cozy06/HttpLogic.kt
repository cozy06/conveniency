package com.github.cozy06

import com.github.cozy06.Logic.Companion.loop
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

class HttpLogic {
    companion object {
        fun params(vararg params: Pair<String, String>): Param {
            return params.toList()
        }

        fun header(vararg header: Pair<String, String>): Header {
            return header.toList()
        }

        fun URL.httpPOST(param: Param? = null, headers: Header= header("Content-Type" to "application/json"), CodePrint: Boolean= false): String? {
            if(param == null) {
                var response: String? = null
                try {
                    val connection = this.openConnection() as HttpURLConnection
                    connection.requestMethod = "POST"
                    connection.doOutput = false
                    connection.connect()
                    val responseCode = connection.responseCode
                    println(responseCode)
                    response = connection.inputStream.bufferedReader().readText()
                    println(response)
                    connection.disconnect()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                return response
            }
            else {
                var json = ""
                repeat(param.size) { json = json + "{\"" + param[it].first + "\",\"" + param[it].second + "\"}," }
                json = json.substring(0, json.length - 1)

                val connection = this.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.doOutput = true
                repeat(headers.size) {
                    connection.setRequestProperty(headers[it].first, headers[it].second)
                }
                val outputStream: OutputStream = connection.outputStream
                outputStream.write(json.toByteArray())
                outputStream.flush()
                outputStream.close()
                val responseCode = connection.responseCode
                if(CodePrint) { println(responseCode) }
                val response = connection.inputStream.bufferedReader().readText()
                connection.disconnect()
                return response
            }
        }

        fun URL.httpGET(param: Param? = null, CodePrint: Boolean = false): String? {
            var url: URL = this
            var response: StringBuilder? = null
            if(param != null) {
                var urlString: String = "?"
                repeat(param.size) { urlString = urlString + param[it].first + "=" + param[it].second + "&" }
                urlString = urlString.substring(0, urlString.length - 1)

                url = URL(url.toString() + urlString)
            }
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            if(CodePrint) { println(responseCode) }
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                response = StringBuilder()

                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    response.append(line)
                }
                reader.close()
            } else {
                println("GET request failed: HTTP error code $responseCode")
            }
            return response.toString()
        }
    }
}

typealias Param = List<Pair<String, String>>
typealias Header = List<Pair<String, String>>