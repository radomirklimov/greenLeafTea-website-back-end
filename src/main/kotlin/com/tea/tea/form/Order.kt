package com.tea.tea.form

data class Order(
    val fullName: String,
    val email: String,
    val tea: MutableMap<Long, String>,
    val deliveryAddress: String,
    val additionalNotes: String
)