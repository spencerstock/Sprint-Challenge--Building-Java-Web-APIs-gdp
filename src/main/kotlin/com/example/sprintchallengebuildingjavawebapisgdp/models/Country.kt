package com.example.sprintchallengebuildingjavawebapisgdp.models

import java.util.concurrent.atomic.AtomicLong

class Country ( val name: String, gdp: String) {
    val id: Long = counter.incrementAndGet()
    val gdp: Long = gdp.toLong()

    companion object {
        private val counter = AtomicLong()
    }
}