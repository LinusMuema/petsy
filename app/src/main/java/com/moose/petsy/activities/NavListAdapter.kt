package com.moose.petsy.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.moose.petsy.R
import com.moose.petsy.databinding.NavItemBinding
import com.moose.petsy.utils.Icon

class NavListAdapter(
    private val items: List<Icon>,
): RecyclerView.Adapter<NavListAdapter.NavViewHolder>() {

    private var selectedIndex: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavViewHolder {
        val binding = NavItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NavViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NavViewHolder, position: Int) {
        val item = items[position]
        if (position == selectedIndex)
            holder.bindStyled(item)
        else
            holder.bind(item)

        holder.itemView.setOnClickListener {
            selectedIndex = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = items.size

    inner class NavViewHolder(private val binding: NavItemBinding): RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context

        fun bind(icon: Icon) {
            with(binding){
                itemLayout.background = null
                navItem.load(icon.drawable)
            }
        }

        fun bindStyled(icon: Icon) {
            val background =  ContextCompat.getDrawable(context, R.drawable.rounded)

            with(binding){
                itemLayout.background = background
                navItem.load(icon.drawable)
            }
        }

    }
}