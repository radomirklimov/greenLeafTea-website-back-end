package com.tea.tea.tea

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeaRepository: JpaRepository<TeaEntity, Long>