package org.d3if4203.assesment2.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Catatan(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val judul: String,
    val catatan: String
)