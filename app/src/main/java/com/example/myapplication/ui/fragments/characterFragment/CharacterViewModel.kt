package com.example.myapplication.ui.fragments.characterFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.core.UIState
import com.example.myapplication.data.model.MainResponse
import com.example.myapplication.data.model.Result
import com.example.myapplication.data.remote.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Author: Dzhaparov Bekmamat
 */
@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    var livedataDetail: LiveData<UIState<MainResponse<Result>>> = MutableLiveData()
    fun getDetailCharacter(id: Int) {
        livedataDetail = characterRepository.getCharacter(id)
    }
}