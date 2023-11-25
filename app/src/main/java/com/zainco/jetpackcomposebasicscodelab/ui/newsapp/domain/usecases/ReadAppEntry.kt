package com.zainco.jetpackcomposebasicscodelab.ui.newsapp.domain.usecases

import com.zainco.jetpackcomposebasicscodelab.ui.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}