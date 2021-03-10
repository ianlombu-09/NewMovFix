package com.lexical.newmovfix.data.api

import com.lexical.newmovfix.data.model.LoginUserResponse
import com.lexical.newmovfix.data.model.MovieResponse
import com.lexical.newmovfix.utils.Credentials
import io.reactivex.Single
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


    @GET("movie/popular?api_key=" + Credentials.API_KEY)
    fun getMovies(): Single<MovieResponse>

}