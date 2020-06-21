package com.example.android.idao.network

import com.squareup.moshi.Json

data class PersonProperty(@field:Json(name = "id") val id: Int,
                          @field:Json(name = "name") val name: String,
                          @field:Json(name = "username") val username: String)

data class UserInfo(@field:Json(name = "username") val username: String,
                    @field:Json(name = "password") val password: String)

data class HeadersIdao(val appToken: String, val authorization: String)

data class DataForApi(@field:Json(name = "accessToken") val accessToken: String,
                      @field:Json(name = "tokenType") val tokenType: String)

data class Team(val nameTeam: String, val members: List<PersonProperty>)