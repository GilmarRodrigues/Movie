package com.br.teste.cubosfilme.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.br.teste.cubosfilme.data.database.entity.MovieCache
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = REPLACE)
    fun insert(movie: MovieCache)

    @Insert(onConflict = REPLACE)
    fun insert(movies: List<MovieCache>)

    @Query("SELECT * FROM movie WHERE id = :id")
    fun get(id: Long): Flow<MovieCache>

    @Query("SELECT * FROM movie ORDER BY id DESC")
    fun getAll(): Flow<List<MovieCache>>

    @Delete
    fun remove(movie: MovieCache)

    @Query("DELETE FROM movie")
    fun clear()

}