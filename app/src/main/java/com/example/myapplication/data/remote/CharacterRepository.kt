package com.example.myapplication.data.remote

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.core.UIState
import com.example.myapplication.data.model.Episode
import com.example.myapplication.data.model.Location
import com.example.myapplication.data.model.MainResponse
import com.example.myapplication.data.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Author: Dzhaparov Bekmamat
 */
class CharacterRepository @Inject constructor(private val api: ApiService) {
    //данный класс отвечает за получение данных о персонажах из удаленного API c использованием Retrofit
    fun getCharacter(id: Int): MutableLiveData<UIState<MainResponse<Result>>> {
        val liveData = MutableLiveData<UIState<MainResponse<Result>>>()
        liveData.value = UIState.Loading()
        api.getCharacters(id).enqueue(object : Callback<MainResponse<Result>> {
            override fun onResponse(
                call: Call<MainResponse<Result>>,
                response: Response<MainResponse<Result>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()
                    liveData.value = UIState.Success(data)
                }
            }

            override fun onFailure(call: Call<MainResponse<Result>>, t: Throwable) {
                liveData.value = UIState.Error(t.message.toString())
            }
        })
        return liveData
    }

    fun getLocation(): MutableLiveData<UIState<MainResponse<Location>>> {
        val liveData = MutableLiveData<UIState<MainResponse<Location>>>()
        liveData.value = UIState.Loading()
        api.getLocation().enqueue(object : Callback<MainResponse<Location>> {
            override fun onResponse(
                call: Call<MainResponse<Location>>,
                response: Response<MainResponse<Location>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val result = response.body()
                    liveData.value = UIState.Success(data = result)
                }
            }

            override fun onFailure(call: Call<MainResponse<Location>>, t: Throwable) {
                liveData.value = UIState.Error(t.message.toString())
            }
        })
        return liveData
    }

    fun getEpisode(): MutableLiveData<UIState<MainResponse<Episode>>> {
        val liveData = MutableLiveData<UIState<MainResponse<Episode>>>()
        liveData.value = UIState.Loading()
        api.getEpisode().enqueue(object : Callback<MainResponse<Episode>> {
            override fun onResponse(
                call: Call<MainResponse<Episode>>,
                response: Response<MainResponse<Episode>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val result = response.body()
                    liveData.value = UIState.Success(data = result)
                }
            }

            override fun onFailure(call: Call<MainResponse<Episode>>, t: Throwable) {
                liveData.value = UIState.Error(t.message.toString())
            }
        })
        return liveData
    }
}
/*
Данный класс CharacterRepository служит для получения данных о персонажах из удаленного API с использованием библиотеки Retrofit. Он является частью архитектурного паттерна репозитория, который отделяет логику работы с данными от остальных компонентов приложения.
 */