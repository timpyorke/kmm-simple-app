package com.mangofactory.kmmsimpleapp.android.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

const val STORE_NAME = "app_data_store"

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = STORE_NAME)

interface PrefDataStore {

}

class PrefDataStoreImpl @Inject constructor(
    @ApplicationContext val context: Context
) : PrefDataStore {

}