package com.loc.catapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.catapp.model.CatItem
import com.loc.catapp.repository.CatRepository
import com.loc.catapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel

class CatViewModel @Inject constructor(
    private val repository: CatRepository
) : ViewModel() {

    private val _cats = MutableLiveData<List<CatItem>>()
    val cats: LiveData<List<CatItem>> = _cats

    init {
        loadCatsBreeds(Constants.API_KEY)
    }

    fun loadCatsBreeds(apiKey: String) {
        viewModelScope.launch {
            try {
                val catList = repository.getCatBreeds(apiKey)
                _cats.value = catList
            } catch (e: Exception) {
                e.printStackTrace()
                _cats.value = emptyList()
            }
        }
    }
}

