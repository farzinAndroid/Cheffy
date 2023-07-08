package com.farzin.cheffy.data.dataStore

interface DataStoreRepository {

    suspend fun putBoolean(key:String,value:Boolean)
    suspend fun getBoolean(key:String) : Boolean?

}