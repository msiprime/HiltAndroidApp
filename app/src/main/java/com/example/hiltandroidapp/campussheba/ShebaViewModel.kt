package com.example.hiltandroidapp.campussheba

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltandroidapp.campussheba.data.model.ShebaCategory
import com.example.hiltandroidapp.campussheba.data.model.ShebaService
import kotlinx.coroutines.launch
import com.example.hiltandroidapp.campussheba.data.remote.ShebaServiceApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class ShebaViewModel @Inject constructor(
    private val shebaServiceApi: ShebaServiceApi
) : ViewModel() {
    var shebaData = mutableStateOf<List<ShebaCategory>>(emptyList())
    init {
        fetchData()
    }
private fun fetchData() {
    viewModelScope.launch {
    shebaData.value = shebaServiceApi.getShebaData().body()?.data ?: emptyList()
    }
}

}

