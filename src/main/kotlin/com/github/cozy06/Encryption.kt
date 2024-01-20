package com.github.cozy06

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

class Encryption {
    companion object {
        fun hashEncryption(input: String, encryptionType: String= "SHA-256"): String {
            val bytes = try {
                MessageDigest.getInstance(encryptionType).digest(input.toByteArray(StandardCharsets.UTF_8))
            } catch (e: Exception) {
                throw e
            }
            return bytes.joinToString("") { "%02x".format(it) }
        }
    }
}