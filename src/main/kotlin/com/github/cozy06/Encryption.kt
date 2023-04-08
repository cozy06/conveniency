package com.github.cozy06

import com.github.cozy06.File.Companion.readFile
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

class Encryption {
    companion object {
        fun hashEncryption(input: String, type: String): String {
            val bytes = try {
                MessageDigest.getInstance("SHA-256").digest(input.toByteArray(StandardCharsets.UTF_8))
            } catch (e: Exception) {
                throw e
            }
            return bytes.joinToString("") { "%02x".format(it) }
        }
    }
}