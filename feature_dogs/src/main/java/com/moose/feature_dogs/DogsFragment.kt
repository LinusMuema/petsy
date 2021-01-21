package com.moose.feature_dogs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.moose.feature_dogs.databinding.FragmentDogsBinding
import com.moose.remote.ApiEndpoints
import com.moose.remote.Endpoints
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DogsFragment : Fragment() {

    private lateinit var binding: FragmentDogsBinding
    private val viewModel: DogsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDogsBinding.inflate(inflater, container, false)
        viewModel.getFact()
        return binding.root
    }

}