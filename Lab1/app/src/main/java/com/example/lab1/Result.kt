package com.example.lab1

import android.content.res.Resources
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import com.squareup.moshi.Json
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

data class MarvelResult(
    @field:Json(name = "data") val data: Data?
)

data class Data(
    @field:Json(name = "results") val results: List<Character>
)

data class Character(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "thumbnail") val thumbnail: Thumbnail?
)

data class Thumbnail(
    @field:Json(name = "path") val path: String?,
    @field:Json(name = "extension") val extension: String?
)


fun getMarvel(): List<ItemRow>{

    val retrofit = Retrofit.Builder()
        .baseUrl(MarvelService.API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service = retrofit.create(MarvelService::class.java)

    val res1 = service.getCharacters().execute()


    val res = res1.body()!!.data!!.results

    val list: MutableList<ItemRow> = mutableListOf()
    var k = 0
    res.forEach { item ->
        list.add(ItemRow(k, 1, item.name!!, Color.Blue, item.description!!, item.thumbnail!!.path+"/portrait_uncanny." + item.thumbnail.extension))
        k++
    }
    Log.i("deb", list.toString())
    return list
}
