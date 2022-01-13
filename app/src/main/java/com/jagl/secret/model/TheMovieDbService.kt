package com.jagl.secret.model

import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbService {

    //popular?apiKey=<apiKey>
    @GET("movie/popular")
    suspend fun listPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("region") region: String,
    ): MovieDbResult

}