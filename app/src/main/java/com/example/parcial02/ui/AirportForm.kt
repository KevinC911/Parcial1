package com.example.parcial02.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial02.R
import com.example.parcial02.databinding.FragmentAirportFormBinding


class AirportForm : Fragment() {
    private lateinit var binding: FragmentAirportFormBinding
    private val viewModel: AirportViewModel by viewModels { AirportViewModel.Factory }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAirportFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
        observeStatus()
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when{
                status.equals(AirportViewModel.WRONG_INFORMATION) -> {
                    viewModel.clearStatus()
                }
                status.equals(AirportViewModel.AIRPORT_CREATED) -> {
                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }

        }
    }


}