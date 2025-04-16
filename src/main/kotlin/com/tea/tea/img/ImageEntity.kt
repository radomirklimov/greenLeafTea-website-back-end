package com.tea.tea.img

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "img_table")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ImageEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Lob
    @Column(name = "imagedata", length = 1000)
    var imageData: ByteArray? = null
)