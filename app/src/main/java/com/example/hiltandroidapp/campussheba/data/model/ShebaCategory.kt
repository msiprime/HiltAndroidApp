package com.example.hiltandroidapp.campussheba.data.model

import com.google.gson.annotations.SerializedName

data class ShebaCategory (


    @SerializedName("name"          ) var name          : String?           = null,
    @SerializedName("description"   ) var description   : String?           = null,
    @SerializedName("imageUrl"      ) var imageUrl      : String?           = null,


)