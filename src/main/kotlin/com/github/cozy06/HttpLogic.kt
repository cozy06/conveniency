package com.github.cozy06

import com.github.cozy06.Repeat.Companion.loop
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

        fun URL.httpPOST(param: Param? = null): String? {
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
                loop({ json = json + "{\"" + param[it].first + "\",\"" + param[it].second + "\"}," }, param.size)
                json = json.substring(0, json.length - 1)

                val connection = this.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", "application/json")
                val outputStream: OutputStream = connection.outputStream
                outputStream.write(json.toByteArray())
                outputStream.flush()
                outputStream.close()
                val responseCode = connection.responseCode
                println(responseCode)
                val response = connection.inputStream.bufferedReader().readText()
                connection.disconnect()
                return response
            }
        }

        fun URL.httpGET(param: Param? = null) {
            var url: URL = this
            if(param != null) {
                var urlString: String = "?"
                loop({ urlString = urlString + param[it].first + "=" + param[it].second + "&" }, param.size)
                urlString = urlString.substring(0, urlString.length - 1)

                url = URL(url.toString() + urlString)
            }
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                val response = StringBuilder()

                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    response.append(line)
                }
                reader.close()

                println(response.toString())
            } else {
                println("GET request failed: HTTP error code $responseCode")
            }
        }
    }
}

typealias Param = List<Pair<String, String>>