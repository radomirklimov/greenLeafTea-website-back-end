package com.tea.tea.img

import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class ImageService(
    val repository: ImageRepository
) {

    fun populateDatabase() {
        val imgs = mutableListOf(
                "img/GoldenAssam.jpeg",
                "img/CeylonSunrise.jpeg",
                "img/JasmineGreen.jpeg",
                "img/ChamomileCalm.jpeg",
                "img/HimalayanOolong.jpeg",
                "img/SpicedChaiBlend.jpeg"
        )

        imgs.forEach { i ->
            val imageData = try {
                val resource = ClassPathResource(i)
                resource.inputStream.readBytes()
            } catch (e: IOException) {
                null
            }

            repository.save(ImageEntity(
                imageData = imageData
            ))
        }
    }

    fun getById(id: Long): ImageEntity? = repository.findById(id).orElse(null)
}