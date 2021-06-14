package com.iug.qudsiapp.ui.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iug.qudsiapp.model.firestore.Subject
import com.iug.qudsiapp.repository.FirestoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubjectsViewModel: ViewModel() {

    var repository = FirestoreRepository()

    var dataSubjects = MutableLiveData<ArrayList<Subject>>()

    fun getSubjects(id: String, name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getSubjects(id, name)
            delay(2000)
            withContext(Dispatchers.Main){
                dataSubjects.postValue(response)
            }
        }
    }

}