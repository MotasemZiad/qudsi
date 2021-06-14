package com.iug.qudsiapp.model.firestore

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Subject(
    val title: String,
    val image: String,
    val description: String
) : Parcelable