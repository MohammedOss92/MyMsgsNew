package com.sarrawi.msgs.models

import com.google.gson.annotations.SerializedName

data class MsgsTypesModel(
    // // sweilem edit
    @SerializedName("id")
    val id:Int ,
    @SerializedName("MsgTypes")
    val MsgTypes:String ,
    @SerializedName("new_msg")
    val new_msg:Int

                          )
