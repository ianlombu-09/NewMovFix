package com.lexical.newmovfix.data.repository

import com.lexical.newmovfix.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    fun getMovies() = apiHelper.getMovies()
}