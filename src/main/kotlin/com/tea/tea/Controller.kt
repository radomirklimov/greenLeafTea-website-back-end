package com.tea.tea

import com.tea.tea.form.EmailService
import com.tea.tea.form.Order
import com.tea.tea.img.ImageService
import com.tea.tea.tea.TeaEntity
import com.tea.tea.tea.TeaService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import kotlin.Long

@CrossOrigin(origins = ["*"])
@RestController
class Controller(
    val teaService: TeaService,
    val imgService: ImageService,
    val emailService: EmailService
){

    @GetMapping("/teas")
    fun getTeas(): ResponseEntity<List<TeaEntity>>{
        val teas = teaService.getAll()

        if (teas == null){
            return ResponseEntity.badRequest().build()
        }

        return ResponseEntity.ok(teas)
    }

    @GetMapping("/img/{id}")
    fun getTeaImage(@PathVariable id: Long): ResponseEntity<ByteArray> {
        val imgEntity = imgService.getById(id) ?: return ResponseEntity.notFound().build()
        val imageData = imgEntity.imageData ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(imageData)
    }

    @PostMapping("/order")
    fun sendOrderForm(@RequestBody order: Order): ResponseEntity<String> {
        val teaInfo = order.tea

        emailService.sendOrderEmail(
            to = "greenleaffteas@gmail.com",
            subject = "New Order from ${order.fullName}",
            body = """
                🧾 New Tea Order
                
                👤 Name: ${order.fullName}
                📧 Email: ${order.email}
                
                🍵 Tea Selection:
                ${order.tea.entries.joinToString("\n") { "- (quantity: ${it.key}), Type: ${it.value}" }}
                
                📦 Delivery Address:
                ${order.deliveryAddress}
                
                📝 Additional Notes:
                ${if (order.additionalNotes.isBlank()) "None" else order.additionalNotes}
                
                ---
                Sent automatically from the Tea Shop App.
            """.trimIndent()
            )

        return ResponseEntity.ok("Order received for ${order.fullName}")
    }
}