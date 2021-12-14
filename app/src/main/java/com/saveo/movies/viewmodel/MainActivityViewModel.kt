package com.saveo.movies.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saveo.movies.model.MovieDetail
import com.saveo.movies.network.RetroInstance
import com.saveo.movies.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var recyclerListLiveData : MutableLiveData<MovieDetail>



    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver():MutableLiveData<MovieDetail>{
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response =retroInstance.getDataFromApi()
            recyclerListLiveData.postValue(response)
        }
    }
}