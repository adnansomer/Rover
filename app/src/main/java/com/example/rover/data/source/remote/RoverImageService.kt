package com.example.rover.data.source.remote

import com.example.rover.models.RoverData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RoverImageService {
    @GET("mars-photos/api/v1/rovers/{roverName}/photos")
    suspend fun getImages(
        @Path("roverName") roverName: String,
        @Query("sol")
        sol: String?,
        @Query("api_key")
        apiKey: String?,
        @Query("camera")
        camera: String?,
        @Query("earth_date")
        earthDate: String?,
        @Query("page")
        page: Int?
    ): Response<RoverData>
}