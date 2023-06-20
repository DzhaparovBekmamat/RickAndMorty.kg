package com.example.myapplication.ui.fragments.episodeFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.core.UIState
import com.example.myapplication.data.model.Episode
import com.example.myapplication.data.model.MainResponse
import com.example.myapplication.data.remote.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Author: Dzhaparov Bekmamat
 */
@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    var livedataDetail: LiveData<UIState<MainResponse<Episode>>> = MutableLiveData()
    fun getDetailEpisode() {
        livedataDetail = characterRepository.getEpisode()
    }
}