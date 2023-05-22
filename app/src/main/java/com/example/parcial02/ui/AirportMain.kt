package com.example.parcial02.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial02.R
import com.example.parcial02.databinding.FragmentAirportMainBinding
import com.example.parcial02.models.AirportModel
import com.example.parcial02.ui.recyclerview.AirportAdapter


class AirportMain : Fragment() {
    private lateinit var binding: FragmentAirportMainBinding
    private val viewModel: AirportViewModel by activityViewModels { AirportViewModel.Factory }
    private lateinit var adapter: AirportAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAirportMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.addAirport.setOnClickListener{
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_airportMain_to_airportForm)
        }

    }

    private fun showSelectedItem(airport:AirportModel) {
        viewModel.setSelectedAirport(airport)
        findNavController().navigate(R.id.action_airportMain_to_airportDetails)
    }

    private fun displayAirports() {
        adapter.setData(viewModel.getAirports())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = AirportAdapter { selectedAirport ->
            showSelectedItem(selectedAirport)
        }
        binding.recyclerView.adapter = adapter
        displayAirports()
    }



}