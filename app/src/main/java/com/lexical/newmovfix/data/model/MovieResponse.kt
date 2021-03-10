package com.lexical.newmovfix.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    val page : Int,
    @SerializedName ("results")
    val popularResults: List<MovieModel>
)
