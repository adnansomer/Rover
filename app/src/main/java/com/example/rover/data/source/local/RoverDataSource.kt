package com.example.rover.data.source.local

import com.example.rover.models.Camera
import com.example.rover.models.Rover
import com.example.rover.data.Result

interface RoverDataSource {
    suspend fun getRovers(): Result<List<Rover>>
    suspend fun getAvailableCameras(roveId: Int): Result<List<Camera>>
}