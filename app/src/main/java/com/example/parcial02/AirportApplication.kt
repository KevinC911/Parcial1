package com.example.parcial02

import android.app.Application
import com.example.parcial02.models.airports
import com.example.parcial02.repository.AirportRepository

class AirportApplication: Application() {
    val airportRepository: AirportRepository by lazy {
        AirportRepository(airports)
    }
}