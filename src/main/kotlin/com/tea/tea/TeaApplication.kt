package com.tea.tea

import com.tea.tea.img.ImageService
import com.tea.tea.tea.TeaService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class TeaApplication {
    @Bean
    fun fillDatabase(teaService: TeaService, imgService: ImageService) = CommandLineRunner {
        teaService.populateDatabase()
        imgService.populateDatabase()
    }
}


fun main(args: Array<String>) {
    runApplication<TeaApplication>(*args)
}
