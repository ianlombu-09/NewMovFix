package com.lexical.newmovfix.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lexical.newmovfix.data.api.ApiHelper
import com.lexical.newmovfix.data.repository.MainRepository
import com.lexical.newmovfix.ui.main.viewmodel.HomeViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(MainRepository(apiHelper)) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}