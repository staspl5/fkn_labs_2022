package com.example.lab1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {

    @GET("http://gateway.marvel.com/v1/public/characters?limit=30&apikey=0b1c04910f9ca3a8847e218554563d39&ts=5558961549846&hash=22062634b9c48f80f366a377f2a5863a")//characters?limit={limit1}&apikey=0b1c04910f9ca3a8847e218554563d39
    fun getCharacters(): Call<MarvelResult>

    @GET("characters/{ID}?apikey=0b1c04910f9ca3a8847e218554563d39")
    fun getCharactersById(@Path("ID") id: String): Call<MarvelResult>

    companion object{
        const val API_URL = "https://gateway.marvel.com:443/v1/public/"
    }
}