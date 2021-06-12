package com.iug.qudsiapp.data.firebase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.iug.qudsiapp.model.News
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.lang.Exception

object FirestoreRepository {
    private lateinit var exception: Exception
    var mNews = MutableLiveData<MutableList<News>>()
    private val instance: FirebaseFirestore by lazy {
        Firebase.firestore
    }

    suspend fun getNews(): LiveData<MutableList<News>> {
        withContext(IO) {
            instance.collection("news").orderBy("date", Query.Direction.DESCENDING)
                .get()
                .addOnSuccessListener { task ->
                    val tempArr = mutableListOf<News>()
                    task.documents.forEach { documentSnapshot ->
                        val news = News(
                            documentSnapshot.id,
                            documentSnapshot.getString("content")!!,
                            documentSnapshot.getString("img")!!,
                            documentSnapshot.getDate("date")!!.time
                        )
                        tempArr.add(news)
                    }
                    mNews.value = tempArr

                }.addOnFailureListener {
                    exception = it
                }
        }
        return mNews
    }
}
