package com.zainco.jetpackcomposebasicscodelab.ui.newsapp.data.manager

import android.content.Context
import com.zainco.jetpackcomposebasicscodelab.ui.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import java.util.prefs.Preferences
import javax.sql.DataSource

class LocalUserManagerImpl(private val context: Context) : LocalUserManager {
    override suspend fun saveAppEntry() {
        TODO("Not yet implemented")
    }

    override fun readAppEntry(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}

private val Context.dataStore : DataSource<Preferences> by preferencesDataStore(name= "")