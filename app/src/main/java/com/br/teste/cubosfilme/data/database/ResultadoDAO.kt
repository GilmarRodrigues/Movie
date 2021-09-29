package com.br.teste.cubosfilme.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ResultadoDAO {

    @Query("SELECT * FROM Resultado ORDER BY id DESC")
    fun buscaTodos(): LiveData<List<Resultado>>

    @Insert(onConflict = REPLACE)
    fun salva(resultado: Resultado)

    @Delete
    fun remove(resultado: Resultado)

    @Query("SELECT * FROM Resultado WHERE id = :id")
    fun buscaPorId(id: Long): LiveData<Resultado?>

    @Insert(onConflict = REPLACE)
    fun salva(resultados: List<Resultado>)

}