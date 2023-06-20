package com.example.myapplication.ui.fragments.episodeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.Episode
import com.example.myapplication.databinding.ItemEpisodeBinding

/**
 * Author: Dzhaparov Bekmamat
 */
class EpisodeAdapter :
    androidx.recyclerview.widget.ListAdapter<Episode, EpisodeAdapter.EpisodeViewHolder>(
        EpisodeDiffCallBack()
    ) {
    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Episode?) {
            binding.textViewNameEpisode.text = model?.name
            binding.textViewEpisodeEpisode.text = model?.episode
            binding.textViewAirDateEpisode.text = model?.airDate
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBinding.inflate(inflater, parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}

class EpisodeDiffCallBack : DiffUtil.ItemCallback<Episode>() {
    override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem == newItem
    }

}
