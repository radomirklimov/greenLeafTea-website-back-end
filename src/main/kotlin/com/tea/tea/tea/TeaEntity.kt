package com.tea.tea.tea

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "tea_table")
class TeaEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var name: String = "",

    var description: String = "",

    var price: String = "",

    var origin: String = "",

    var notes: String = "",
)