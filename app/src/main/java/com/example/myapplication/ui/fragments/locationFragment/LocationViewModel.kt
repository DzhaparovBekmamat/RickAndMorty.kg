package com.example.myapplication.ui.fragments.locationFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.core.UIState
import com.example.myapplication.data.model.Location
import com.example.myapplication.data.model.MainResponse
import com.example.myapplication.data.remote.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Author: Dzhaparov Bekmamat
 */
@HiltViewModel
class LocationViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    var livedataDetail: LiveData<UIState<MainResponse<Location>>> = MutableLiveData()
    fun getDetailLocation() {
        livedataDetail = characterRepository.getLocation()
    }
}