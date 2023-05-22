package com.example.parcial02.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial02.models.AirportModel
import com.example.parcial02.repository.AirportRepository

class AirportViewModel(private val repository: AirportRepository) {
    // Variables to use in VM
    var name = MutableList("")

    //Functions to interact with the data of VW
    fun getAirports() = repository.getAirports()
    fun addAirport(airport:AirportModel) = repository.addAirport(airport)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY]
            }
        }
    }
}