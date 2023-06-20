package com.example.myapplication.ui.fragments.locationFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.Location
import com.example.myapplication.databinding.ItemLocationBinding

/**
 * Author: Dzhaparov Bekmamat
 */
class LocationAdapter :
    ListAdapter<Location, LocationAdapter.LocationViewHolder>(LocationDiffCallBack()) {

    class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Location?) {
            binding.textViewNameLocation.text = model?.name
            binding.textViewDestinationLocation.text = model?.type
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLocationBinding.inflate(inflater, parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}

class LocationDiffCallBack : DiffUtil.ItemCallback<Location>() {
    override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
        return oldItem == newItem
    }
}
