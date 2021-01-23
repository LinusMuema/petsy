package com.moose.feature_dogs.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.moose.feature_dogs.databinding.FragmentDogsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DogsFragment : Fragment() {

    private lateinit var binding: FragmentDogsBinding
    private val viewModel: DogsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDogsBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            viewModel.dogs.collect {
                Log.d("Petsy", "onCreateView: $it")
            }
        }

        viewModel.startWork(requireContext())
        return binding.root
    }

}