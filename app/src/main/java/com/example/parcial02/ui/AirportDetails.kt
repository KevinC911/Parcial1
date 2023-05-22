package com.example.parcial02.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.parcial02.R
import com.example.parcial02.databinding.FragmentAirportDetailsBinding


class AirportDetails : Fragment() {
    private lateinit var binding: FragmentAirportDetailsBinding
    private val viewModel: AirportViewModel by activityViewModels { AirportViewModel.Factory }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAirportDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    private fun bind(){
        viewModel.getSelectedAirport().observe(viewLifecycleOwner, Observer { airport ->
            binding.nameText.text = airport.name
            binding.locationText.text = airport.location
        })
    }



}