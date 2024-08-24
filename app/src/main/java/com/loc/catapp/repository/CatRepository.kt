package com.loc.catapp.repository

import com.loc.catapp.model.CatItem
import com.loc.catapp.service.CatApiService
import javax.inject.Inject

class CatRepository @Inject constructor(
    private val apiService: CatApiService
) {
    suspend fun getCatBreeds(apiKey:String): List<CatItem> {
        return apiService.getCats(apiKey)
    }
}