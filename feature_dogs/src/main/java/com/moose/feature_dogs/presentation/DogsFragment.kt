package com.moose.feature_dogs.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.moose.feature_dogs.R
import com.moose.feature_dogs.databinding.FragmentDogsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DogsFragment : Fragment(R.layout.fragment_dogs) {

    private lateinit var binding: FragmentDogsBinding
    private val viewModel: DogsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDogsBinding.bind(view)

        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        manager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS

        viewModel.dogs.observe( viewLifecycleOwner, {
            binding.recyclerView.apply {
                layoutManager = manager
                setHasFixedSize(true)
                adapter = AnimalsListAdapter(it.images)
            }
        })
    }
}