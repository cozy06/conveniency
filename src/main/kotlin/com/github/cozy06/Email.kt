package com.github.cozy06

import com.github.cozy06.Async.Companion.async
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class Email {
    companion object {
        /**
         * Email 전송
         * @param to 수신 Email
         * @param subject 제목
         * @param body 본문 내용
         * @param from 송신 Email, Google에서 발급 필요
         * @param appPassword 송신 Email의 appPassword, Google에서 발급 필요
         */
        fun sendEmail(to: String, subject: String, body: String, from: String, appPassword: String) {
            async {
                val props = Properties().apply {
                    put("mail.smtp.auth", "true")
                    put("mail.smtp.host", "smtp.gmail.com")
                    put("mail.smtp.port", "587")
                    put("mail.smtp.starttls.enable", "true")
                }

                val session = Session.getInstance(props, object : Authenticator() {
                    override fun getPasswordAuthentication(): PasswordAuthentication {
                        return PasswordAuthentication(from, appPassword)
                    }
                })

                val message = MimeMessage(session).apply {
                    setFrom(InternetAddress(from))
                    setRecipients(Message.RecipientType.TO, InternetAddress.parse(to))
                    setSubject(subject)
                    setText(body)
                }

                Transport.send(message)
            }
        }
    }
}