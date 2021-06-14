package com.iug.qudsiapp.ui.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iug.qudsiapp.model.firestore.Title
import com.iug.qudsiapp.repository.FirestoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TitlesViewModel: ViewModel() {

    var repository = FirestoreRepository()

    var dataTitles = MutableLiveData<ArrayList<Title>>()

    fun getTitles() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getTitles()
            delay(2000)
            withContext(Dispatchers.Main){
                dataTitles.postValue(response)
            }
        }
    }

}