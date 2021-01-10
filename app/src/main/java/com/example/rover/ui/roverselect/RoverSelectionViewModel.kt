package com.example.rover.ui.roverselect

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.rover.base.ui.BaseViewModel
import com.example.rover.data.Result
import com.example.rover.data.source.RoverRepository
import com.example.rover.models.QueryModel
import com.example.rover.models.Rover
import kotlinx.coroutines.launch


class RoverSelectionViewModel @ViewModelInject constructor(private val roverRepository: RoverRepository) :
    BaseViewModel() {

    private lateinit var selectedRover: Rover

    private val _rovers = MutableLiveData<List<Rover>>()
    val rovers: LiveData<List<Rover>> = _rovers

    private val _gotoNextActivity = MutableLiveData<Boolean>()
    val gotoNextActivity: LiveData<QueryModel> = _gotoNextActivity.switchMap { isGotoNextActivity ->
        val model = QueryModel()
        if (isGotoNextActivity) {
            model.name = selectedRover.name
            model.sol = "1000"
            model.roverId = selectedRover.id
        }
        return@switchMap MutableLiveData<QueryModel>(model)
    }

    init {
        getRovers()
    }

    private fun getRovers() {
        viewModelScope.launch {
            showLoader.value = true
            val roversData = roverRepository.getRovers()
            if (roversData is Result.Success) {
                _rovers.value = roversData.data!!
                showLoader.value = false
            }
        }
    }

    fun setSelectedRover(position: Int) {
        _rovers.value?.let {
            selectedRover = it[position]
        }
    }

    fun goToNextActivity() {
        _gotoNextActivity.value = true
    }
}