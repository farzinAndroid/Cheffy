package com.farzin.cheffy.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.farzin.cheffy.utils.Constants.DATASTORE_NAME
import kotlinx.coroutines.flow.first
import javax.inject.Inject


private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)


class DataStoreRepositoryImpl @Inject constructor(
    private val context: Context,
) : DataStoreRepository {
    override suspend fun putBoolean(key: String, value: Boolean) {
        val preferenceKey = booleanPreferencesKey(key)
        context.datastore.edit { preference->
            preference[preferenceKey] = value
        }
    }

    override suspend fun getBoolean(key: String): Boolean? {
        return try {
            val preferenceKey = booleanPreferencesKey(key)
            val preferences = context.datastore.data.first()
            preferences[preferenceKey]
        }catch (e:Exception){
            e.printStackTrace()
            null
        }
    }
}