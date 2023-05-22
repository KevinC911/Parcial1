package com.example.parcial02.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial02.AirportApplication
import com.example.parcial02.models.AirportModel
import com.example.parcial02.repository.AirportRepository

class AirportViewModel(private val repository: AirportRepository): ViewModel() {
    // Variables to use in VM
    var name = MutableLiveData("")
    var location = MutableLiveData("")
    var status = MutableLiveData("")
    var anAirport = MutableLiveData<AirportModel>()

    //Functions to interact with the data of VW
    fun getAirports() = repository.getAirports()
    private fun addAirport(airport:AirportModel) = repository.addAirport(airport)

    fun createAirport() {
        if(!validateData()) {
            status.value = WRONG_INFORMATION
        }

        val airport = AirportModel(
            name.value!!,
            location.value!!
        )
        addAirport(airport)
        clearData()

        status.value = AIRPORT_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            location.value.isNullOrEmpty() -> return false
        }
        return true
    }

    private fun clearData() {
        name.value = ""
        location.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as AirportApplication
                AirportViewModel(app.airportRepository)
            }
        }
        const val AIRPORT_CREATED = "Airport created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}