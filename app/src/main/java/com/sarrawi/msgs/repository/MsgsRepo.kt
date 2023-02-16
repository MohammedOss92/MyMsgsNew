package com.sarrawi.msgs.repository

import com.sarrawi.msgs.api.ApiService


class MsgsRepo constructor(val apiService: ApiService) {

    suspend fun getMsgs_Ser(ID_Type_id:Int)= apiService.getMsgs_Ser(ID_Type_id)
}