package com.example.hiltandroidapp.campussheba.data.model

import com.google.gson.annotations.SerializedName

data class ShebaCategory (


    @SerializedName("_id"           ) var Id            : String?           = null,
    @SerializedName("name"          ) var name          : String?           = null,
    @SerializedName("description"   ) var description   : String?           = null,
    @SerializedName("imageUrl"      ) var imageUrl      : String?           = null,
   // @SerializedName("subCategories" ) var subCategories : ArrayList<String> = arrayListOf(),
    @SerializedName("shebaId"       ) var shebaId       : String?           = null,
   // @SerializedName("products"      ) var products      : ArrayList<String> = arrayListOf(),
    //@SerializedName("tagLineList"   ) var tagLineList   : ArrayList<String> = arrayListOf(),
   // @SerializedName("typeList"      ) var typeList      : ArrayList<String> = arrayListOf(),
    //@SerializedName("reviewList"    ) var reviewList    : ArrayList<String> = arrayListOf(),
   // @SerializedName("faqList"       ) var faqList       : ArrayList<String> = arrayListOf(),
    @SerializedName("__v"           ) var _v            : Int?              = null


)