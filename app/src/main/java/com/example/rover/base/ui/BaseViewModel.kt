package com.example.rover.base.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel : ViewModel() {
    val showLoader = MutableLiveData<Boolean>(false)
    val showErrorMessage = MutableLiveData<String>()
}