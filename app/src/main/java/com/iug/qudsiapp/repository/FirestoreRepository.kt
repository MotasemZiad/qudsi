package com.iug.qudsiapp.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.iug.qudsiapp.model.firestore.Subject
import com.iug.qudsiapp.model.firestore.Title

class FirestoreRepository {

    private val instance: FirebaseFirestore by lazy {
        Firebase.firestore
    }

    fun getTitles(): ArrayList<Title> {
        val titles = ArrayList<Title>()
        instance.collection("cities")
            .get()
            .addOnSuccessListener { task ->
                task.documents.forEach { documentSnapshot ->
                    val title = Title(
                        documentSnapshot.id,
                        documentSnapshot.getString("title")!!,
                        documentSnapshot.getString("image")!!
                    )
                    titles.add(title)
                }
            }.addOnFailureListener {
                Log.e("TAG", "getTitles repo fail: $it")
            }
        return titles
    }

    fun getSubjects(id: String, name: String): ArrayList<Subject> {
        val subjects = ArrayList<Subject>()
        instance.collection("cities").document(id).collection(name)
            .get()
            .addOnSuccessListener { task ->
                task.documents.forEach { documentSnapshot ->
                    val subject = Subject(
                        documentSnapshot.getString("name")!!,
                        documentSnapshot.getString("image")!!,
                        documentSnapshot.getString("desc")!!
                    )
                    subjects.add(subject)
                }
            }.addOnFailureListener {
                Log.e("TAG", "getTitles repo fail: $it")
            }
        return subjects
    }

}