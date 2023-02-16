package com.messages.abdallah.mymessages.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarrawi.msgs.api.ApiService
import com.sarrawi.msgs.models.MsgsTypesModel
import com.sarrawi.msgs.repository.MsgsTypesRepo

import kotlinx.coroutines.launch

class MsgsTypesViewModel : ViewModel() {

    private val retrofitService = ApiService.provideRetrofitInstance()
    private val msgsTypesRepo = MsgsTypesRepo(retrofitService)

    private val _response = MutableLiveData<List<MsgsTypesModel>>()
    val responseMsgsTypes : LiveData<List<MsgsTypesModel>>
    get() =_response

    init {
        getAllMsgsTypes()
    }

    private fun getAllMsgsTypes() = viewModelScope.launch {
        msgsTypesRepo.getMsgsTypes_Ser().let { response ->
            Log.d("sww", "dfrr")
            Log.d("sww", "" + response.body())
            if (response.isSuccessful) {
                // sweilem edit
                Log.i("TestRoom", "getAllMsgsTypes: data returned successful")
                _response.postValue(response.body()?.results)
                Log.i("TestRoom", "getAllMsgsTypes: posts ${response.body()?.results}")
                //here get data from api so will insert it to local database
               // msgsTypesRepo.insertPosts(response.body()?.results)
            } else {
                Log.i("TestRoom", "getAllMsgsTypes: data corrupted")
                Log.d("tag", "getAll Error: ${response.code()}")
            }
        }
    }

}