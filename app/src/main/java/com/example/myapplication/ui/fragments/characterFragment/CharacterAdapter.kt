package com.example.myapplication.ui.fragments.characterFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.myapplication.data.model.Result
import com.example.myapplication.databinding.ItemCharacterBinding

/**
 * Author: Dzhaparov Bekmamat
 */
class CharacterAdapter :
    ListAdapter<Result, CharacterAdapter.CharacterViewHolder>(
        CharacterDiffCallBack()
    ) {
    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Result?) {
            binding.textViewNameCharacter.text = model?.name
            binding.textViewGenderCharacter.text = model?.gender
            binding.textViewStatusCharacter.text = model?.status
            val imageUrl = model?.image
            Glide.with(binding.root.context).load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imageViewCharacter)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val model = getItem(position)
        holder.onBind(model)
    }
}

class CharacterDiffCallBack : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }
}
