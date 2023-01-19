package com.sarrawi.msgs.models

import com.google.gson.annotations.SerializedName

//class MsgsTypesResponse: ArrayList<MsgsTypesModel>()
data class MsgsTypesResponse(
    //                  // sweilem edit
    @SerializedName("MsgsTypesModel")
    val results: List<MsgsTypesModel>
)