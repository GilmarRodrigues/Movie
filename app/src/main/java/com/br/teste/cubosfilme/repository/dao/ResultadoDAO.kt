package com.br.teste.cubosfilme.repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.br.teste.cubosfilme.model.Filme
import com.br.teste.cubosfilme.model.Resultado

@Dao
interface ResultadoDAO {

    @Query("SELECT * FROM Resultado ORDER BY id DESC")
    fun buscaTodos(): List<Resultado>

    @Insert(onConflict = REPLACE)
    fun salva(resultado: Resultado)

    @Delete
    fun remove(resultado: Resultado)

    @Query("SELECT * FROM Resultado WHERE id = :id")
    fun buscaPorId(id: Long): Resultado?

    @Insert(onConflict = REPLACE)
    fun salva(resultados: List<Resultado>)

}