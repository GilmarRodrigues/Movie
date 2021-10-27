package com.br.teste.cubosfilme.data.database.preferences

internal interface SharedPreferenceLocalDataSet {
    fun getString(key: String): String
    fun putString(key: String, value: String)
    fun putBoolean(key: String, value: Boolean)
    fun getLong(key: String): Long
    fun getInt(key: String): Int
    fun putLong(key: String, timestamp: Long)
    fun putInt(key: String, value: Int)
    fun deleteKey(key: String)
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean
    fun remove(key: String)
}