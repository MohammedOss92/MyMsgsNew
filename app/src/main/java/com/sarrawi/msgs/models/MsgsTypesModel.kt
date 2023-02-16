package com.sarrawi.msgs.models

import androidx.annotation.NonNull

import com.google.gson.annotations.SerializedName


data class MsgsTypesModel(
    // // sweilem edit


    @SerializedName("id")
    @NonNull
    var id: Int = 0,

    @SerializedName("MsgTypes")
    var MsgTypes: String?,

    @SerializedName("new_msg")
    var new_msg: Int
)
