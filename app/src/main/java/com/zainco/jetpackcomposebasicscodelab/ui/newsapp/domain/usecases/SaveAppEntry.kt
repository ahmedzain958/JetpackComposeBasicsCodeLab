package com.zainco.jetpackcomposebasicscodelab.ui.newsapp.domain.usecases

import com.zainco.jetpackcomposebasicscodelab.ui.newsapp.domain.manager.LocalUserManager

/*
we pass the interface as a parameter not the implementation because what if we wanted to add another implementation method for saving the app entry,
by passing that interface we assure passing various implementations for this one, which makes it more testable, scalable
 */
class SaveAppEntry(private val localUserManager: LocalUserManager) {
    //    fun saveAppEntry
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}