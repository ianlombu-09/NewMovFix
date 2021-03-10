package com.lexical.newmovfix.data.api

import com.lexical.newmovfix.data.model.LoginUserResponse
import com.lexical.newmovfix.data.model.MovieResponse
import com.lexical.newmovfix.utils.Credentials
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("user/login")
    fun login(@Query("email") email: String, @Query("password") password: String): Single<LoginUserResponse>

    @GET("movie/popular?api_key=" + Credentials.API_KEY)
    fun getAllData(): Single<MovieResponse>

}