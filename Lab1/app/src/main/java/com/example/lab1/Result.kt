package com.example.lab1

import com.squareup.moshi.Json

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
