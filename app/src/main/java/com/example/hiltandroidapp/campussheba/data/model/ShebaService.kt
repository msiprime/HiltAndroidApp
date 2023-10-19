package com.example.hiltandroidapp.campussheba.data.model

import com.google.gson.annotations.SerializedName

data class ShebaService (

    @SerializedName("success" ) var success : Boolean?        = null,
    @SerializedName("data"    ) var data    : ArrayList<ShebaCategory> = arrayListOf()

)