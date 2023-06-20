package com.example.myapplication.data.remote

import com.example.myapplication.data.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //интерфейс определяет методы для выполнения запросов к удаленному серверу с использованием библиотеки Retrofit
    @GET("character")//гет запрос на эндчпоинт character
    fun getCharacters( //этот метод принимает параметр page, который указывает номер страницы для пагинации результатов
        @Query("page") page: Int? = 1
    ): Call<MainResponse<Result>>//метод возвращает обьект Call<MainResponse>, который представляет асихронный вызов и ожидаемый ответ в виде обьекта MainResponse

    @GET("location")
    fun getLocation(
    ): Call<MainResponse<Location>>

    @GET("episode")
    fun getEpisode(
    ): Call<MainResponse<Episode>>
}
/*
Аннотации, примененные к каждому методу, указывают тип HTTP-запроса, URL-шаблон  и параметры запроса:
Аннотация GET указывает на выполнение гет запроса
Аннотация Query используется для передачи параметров запроса, в данном случае, праметр page
Аннотация Path используется для передачи пути в URL , в данном случае, параметр id
 */
/*
Данный код представляет интерфейс ApiService, который определяет методы для выполнения запросов к удаленному серверу с использованием библиотеки Retrofit.
 */