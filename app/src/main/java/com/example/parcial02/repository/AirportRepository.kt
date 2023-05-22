package com.example.parcial02.repository

import com.example.parcial02.models.AirportModel

class AirportRepository(private val airports: MutableList<AirportModel>) {
    // Functions to get and set
    fun getAirports() = airports
    fun addAirport(airport:AirportModel) = airports.add(airport)
}