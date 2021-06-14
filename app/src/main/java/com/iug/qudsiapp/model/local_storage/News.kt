package com.iug.qudsiapp.model.local_storage

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "news_table")
data class News(
    @PrimaryKey
    val id: String,
    val image: String,
    val title: String,
    val description: String
) : Parcelable