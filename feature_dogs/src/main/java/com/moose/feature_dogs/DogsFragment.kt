package com.moose.feature_dogs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moose.feature_dogs.databinding.FragmentDogsBinding
import com.moose.remote.ApiEndpoints
import com.moose.remote.Endpoints
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DogsFragment : Fragment() {

    @Inject
    @Endpoints
    lateinit var apiEndpoints: ApiEndpoints

    private lateinit var binding: FragmentDogsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDogsBinding.inflate(inflater, container, false)
        Log.d("Petsy", "onCreateView: $apiEndpoints")
        return binding.root
    }

}