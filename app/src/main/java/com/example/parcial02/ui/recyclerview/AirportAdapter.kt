package com.example.parcial02.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial02.databinding.FragmentAirportListBinding
import com.example.parcial02.models.AirportModel

class AirportAdapter (private val clickListener: (AirportModel) -> Unit): RecyclerView.Adapter<AirportViewHolder>(){
    private val airports = ArrayList<AirportModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirportViewHolder {
        val binding = FragmentAirportListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AirportViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return airports.size
    }

    override fun onBindViewHolder(holder: AirportViewHolder, position: Int) {
        val airport = airports[position]
        holder.bind(airport, clickListener)
    }

    fun setData(airportsList: List<AirportModel>) {
        airports.clear()
        airports.addAll(airportsList)
    }

}