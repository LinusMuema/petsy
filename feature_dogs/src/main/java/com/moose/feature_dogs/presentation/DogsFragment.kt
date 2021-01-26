package com.moose.feature_dogs.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.moose.feature_dogs.R
import com.moose.feature_dogs.databinding.FragmentDogsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogsFragment : Fragment(R.layout.fragment_dogs) {

    private lateinit var binding: FragmentDogsBinding
    private val viewModel: DogsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDogsBinding.bind(view)
        val layout = binding.motionLayout

        binding.fab.setOnClickListener {
            layout.transitionToState(R.id.end)
        }

        binding.overlay.setOnClickListener {
            layout.transitionToState(R.id.start)
        }

        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        manager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS

        viewModel.dogs.observe( viewLifecycleOwner, {
            binding.fact.text = it.fact
            binding.recyclerView.apply {
                layoutManager = manager
                setHasFixedSize(true)
                adapter = AnimalsListAdapter(it.images)
            }
        })
    }
}