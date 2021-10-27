package com.br.teste.cubosfilme.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.br.teste.cubosfilme.data.database.dao.MovieDao
import com.br.teste.cubosfilme.data.database.entity.MovieCache

private const val NOME_BANCO_DADOS = "filme.db"
private const val VERSAO_BANCO_DADOS = 4

@Database(entities = [MovieCache::class], version = VERSAO_BANCO_DADOS, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {

        private lateinit var db: AppDatabase

        fun getInstance(context: Context): AppDatabase {
            if (::db.isInitialized) return db

            db = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                NOME_BANCO_DADOS
            ).build()

            return db
        }
    }
}