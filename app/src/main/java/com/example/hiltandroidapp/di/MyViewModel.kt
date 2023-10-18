package com.example.hiltandroidapp.di

import androidx.lifecycle.ViewModel
import com.example.hiltandroidapp.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
): ViewModel() {

}