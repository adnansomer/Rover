package com.example.rover.data.source

import com.example.rover.data.Result
import com.example.rover.models.Camera
import com.example.rover.models.Rover
import com.example.rover.models.RoverData
import kotlinx.coroutines.flow.Flow

interface RoverRepository {
    suspend fun getRovers(): Result<List<Rover>>
    suspend fun getAvailableCameras(roverId: Int): Result<List<Camera>>
    suspend fun getImages(
        name : String,
        sol: String?,
        apiKey: String?,
        camera: String?,
        earthDate: String?,
        page: Int?
    ): Flow<Result<RoverData>>
}