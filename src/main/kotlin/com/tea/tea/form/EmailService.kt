package com.tea.tea.form

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val mailSender: JavaMailSender
) {
    fun sendOrderEmail(to: String, subject: String, body: String){
        val message = SimpleMailMessage().apply {
            setTo(to)
            setSubject(subject)
            setText(body)
        }
        mailSender.send(message)
    }
}