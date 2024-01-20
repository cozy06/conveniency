package com.github.cozy06

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

class HttpLogic {
    companion object {
        /**
         * 파라미터 생성
         * @param params 파라미터
         * @return Param
         */
        fun params(vararg params: Pair<String, String>): Param {
            return params.toList()
        }

        /**
         * 헤더 생성
         * @param header 헤더
         * @return Header
         */
        fun header(vararg header: Pair<String, String>): Header {
            return header.toList()
        }

        /**
         * http Post 통신
         * @param param 파라미터, 생략 가능
         * @param headers 헤더, 기본값 header("Content-Type" to "application/json")
         * @param codePrint 결과코드 출력 여부, 기본값 false
         * @return String 형식의 response
         */
        fun URL.httpPOST(param: Param? = null, headers: Header= header("Content-Type" to "application/json"), codePrint: Boolean= false): String? {
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
                if(codePrint) { println(responseCode) }
                val response = connection.inputStream.bufferedReader().readText()
                connection.disconnect()
                return response
            }
        }

        /**
         * http Get 통신
         * @param param 파라미터, 생략 가능
         * @param codePrint 결과코드 출력 여부, 기본값 false
         * @return String 형식의 response
         */
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

/**
 * 파라미터와 헤더 타입 선언
 */
typealias Param = List<Pair<String, String>>
typealias Header = List<Pair<String, String>>