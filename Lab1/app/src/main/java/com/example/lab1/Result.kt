package com.example.lab1

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.squareup.moshi.Json
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.UnknownHostException

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
    val colors = listOf(Color.DarkGray, Color.Blue, Color.Cyan, Color.Green, Color.Red,
        Color.Yellow, Color.LightGray, Color(0xFF123EAB),  Color(0xFFBF9030),
        Color(0xFFD91818), Color(0xFF6C0303), Color(0xFF2A0000), Color(0xFF65247F))

    val retrofit = Retrofit.Builder()
        .baseUrl(MarvelService.API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service = retrofit.create(MarvelService::class.java)
    val list: MutableList<ItemRow> = mutableListOf()
    try {
        val res = service.getCharacters().execute().body()!!.data!!.results
        var k = 0
        res.forEach { item ->
            if (item.thumbnail!!.path.toString() != "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available") {
                list.add(
                    ItemRow(
                        k,
                        item.name!!,
                        colors.random(),
                        item.description!!,
                        item.thumbnail.path + "/portrait_uncanny." + item.thumbnail.extension
                    )
                )
                k++
            }
        }
        Log.i("deb", list.toString())
    } catch (e: UnknownHostException) {
        list.add(ItemRow(0, "Error", Color.Gray, "", ""))
    }

    return list
}

@Composable
fun ErrorMessage(){
    Text(
        text = "Нет подключения к интернету, не удалось загрузить данные!", modifier = Modifier.padding(start = 30.dp, top = 40.dp),
        style = TextStyle(color = Color.Black, fontSize = 35.sp)
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        Alignment.Center
    ) {
        Button(onClick = {
            android.os.Process.killProcess(android.os.Process.myPid())
        }) {
            Text(
                text = "Выход",
                style = TextStyle(color = Color.White)
            )
        }
    }
}
