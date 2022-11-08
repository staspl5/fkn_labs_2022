package com.example.lab1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {

    @GET("characters?limit={limit}&apikey=0b1c04910f9ca3a8847e218554563d39")
    fun getCharacters(@Path("limit") limit: String): Call<MarvelResult>

    @GET("characters/{ID}?apikey=0b1c04910f9ca3a8847e218554563d39")
    fun getCharactersById(@Path("ID") id: String): Call<MarvelResult>

    companion object{
        const val API_URL = "https://gateway.marvel.com:443/v1/public/"
    }
}