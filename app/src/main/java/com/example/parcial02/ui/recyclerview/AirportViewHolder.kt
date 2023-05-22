package com.example.parcial02.ui.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.parcial02.databinding.FragmentAirportListBinding
import com.example.parcial02.models.AirportModel

class AirportViewHolder(private val binding: FragmentAirportListBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(airport: AirportModel, clickListener: (AirportModel) -> Unit) {
        binding.airName.text = airport.name
        binding.aitLocation.text = airport.location

        binding.cardListView.setOnClickListener{
            clickListener(airport)
        }
    }
}