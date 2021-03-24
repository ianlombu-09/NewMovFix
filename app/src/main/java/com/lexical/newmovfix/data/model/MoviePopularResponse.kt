package com.lexical.newmovfix.data.model

import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import retrofit2.Response

data class MoviePopularResponse (

    @SerializedName("page")
    val page : Int,

    @SerializedName ("results")
    val popularResults: List<MoviePopularModel>
)
