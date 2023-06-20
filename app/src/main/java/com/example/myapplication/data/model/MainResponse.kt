package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class MainResponse<T>(
    val info: Info, val results: List<T>
)

data class Info(
    val count: Int, val next: String, val pages: Int, val prev: String
)

data class Location(
    val name: String, val url: String, val type: String, val dimension: String
)

data class Episode(
    val name: String, @SerializedName("air_date") val airDate: String, val episode: String
)

data class Origin(
    val name: String, val url: String
)

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)