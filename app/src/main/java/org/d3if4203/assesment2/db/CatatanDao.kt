package org.d3if4203.assesment2.db

import androidx.room.*

@Dao
interface CatatanDao {
    @Insert
    suspend fun addCatatan(note: Catatan)
    @Query("SELECT * FROM catatan ORDER BY id DESC")
    suspend fun getCatatans() : List<Catatan>
    @Update
    suspend fun updateCatatan(note: Catatan)
    @Delete
    suspend fun deleteCatatan(note: Catatan)
}