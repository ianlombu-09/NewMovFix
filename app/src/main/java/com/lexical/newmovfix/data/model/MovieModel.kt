package com.lexical.newmovfix.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MovieModel (

    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("release_date")
    val release_date: String,

    @SerializedName("overview")
    val movie_overview: String,

    @SerializedName("id")
    val movie_id: Int,

    @SerializedName("vote_average")
    val vote_average: Float

)