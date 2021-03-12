package com.lexical.newmovfix.data.api

import com.lexical.newmovfix.data.model.LoginUserResponse
import com.lexical.newmovfix.data.model.MovieModel
import com.lexical.newmovfix.data.model.MoviePopularResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("user/login")
    fun login(@Query("email") email: String, @Query("password") password: String): Single<LoginUserResponse>

    @FormUrlEncoded
    @POST("user/register")
    fun register(@Field("email") email: String,
                 @Field("name") name: String,
                 @Field("address") address: String,
                 @Field("dob") dob: String,
                 @Field("password") password: String
                ): Single<LoginUserResponse>


    @GET("movie/popular?api_key=b1fbb59223a6f5e7113c60d079c7c503")
    fun getPopularMovies(): Single<MoviePopularResponse>

    @GET("movie/458576?api_key=b1fbb59223a6f5e7113c60d079c7c503")
    suspend fun getDetailMovie(): Response<MovieModel>
}