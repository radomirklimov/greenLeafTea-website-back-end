package com.tea.tea.tea

import org.springframework.stereotype.Service

@Service
class TeaService(
    val repository: TeaRepository
) {

    fun populateDatabase() {
        val teaProducts = mutableListOf(
            mutableListOf(
                "Golden Assam",
                "Strong and malty black tea",
                "$9",
                "India",
                "Bold morning flavor"
            ),
            mutableListOf(
                "Ceylon Sunrise",
                "Bright and citrusy with a floral finish",
                "$10",
                "Sri Lanka",
                "Great with lemon",
            ),
            mutableListOf(
                "Jasmine Green",
                "Light green tea infused with jasmine flowers",
                "$11",
                "China",
                "Smooth, aromatic",
            ),
            mutableListOf(
                "Chamomile Calm",
                "Caffeine-free herbal blend",
                "$8",
                "Egypt",
                "Soothing for evenings",
            ),
            mutableListOf(
                "Himalayan Oolong",
                "Complex, floral, slightly sweet",
                "$13",
                "Nepal",
                "Grown at high altitude",
            ),
            mutableListOf(
                "Spiced Chai Blend",
                "Black tea with cinnamon, ginger, cardamom",
                "$10",
                "India",
                "Perfect with milk & honey",
            )
        )

        teaProducts.forEach { tea ->
            repository.save(TeaEntity(
                name = tea[0],
                description = tea[1],
                price = tea[2],
                origin = tea[3],
                notes = tea[4],
            ))
        }
    }

    fun getAll(): List<TeaEntity>?{
        return repository.findAll()
    }
}