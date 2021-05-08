package com.iug.qudsiapp.data.firebase

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.iug.qudsiapp.model.News
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

object FirestoreRepository {
    lateinit var exception: Exception
    private var mNews = MutableLiveData<MutableList<News>>()
    private val instance: FirebaseFirestore by lazy {
        Firebase.firestore
    }

    fun getNews():LiveData<MutableList<News>> {
        instance.collection("news").orderBy("date", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { task ->
                val tempArr = mutableListOf<News>()
                task.documents.forEach { documentSnapshot ->
                    val news = News(
                        documentSnapshot.getString("id")!!,
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

        return mNews
    }
}
