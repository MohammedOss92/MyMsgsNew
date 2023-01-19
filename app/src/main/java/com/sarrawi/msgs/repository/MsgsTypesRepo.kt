package com.sarrawi.msgs.repository

import com.sarrawi.msgs.api.ApiService

class MsgsTypesRepo
//@Inject
constructor(private val apiService: ApiService){

    suspend fun getMsgsTypes_Ser() = apiService.getMsgsTypes_Ser()
}