package com.loc.catapp.service

import com.loc.catapp.model.Cat
import com.loc.catapp.model.CatItem
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiService {
    @GET("breeds")
    suspend fun getCats(
        @Query("api-key") apiKey: String
    ): List<CatItem>

}