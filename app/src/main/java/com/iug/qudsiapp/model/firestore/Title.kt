package com.iug.qudsiapp.model.firestore

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Title(
    val id: String,
    val name: String,
    val image: String
) : Parcelable