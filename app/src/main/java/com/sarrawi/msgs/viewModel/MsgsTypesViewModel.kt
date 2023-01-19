package com.sarrawi.msgs.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarrawi.msgs.models.MsgsTypesModel
import com.sarrawi.msgs.repository.MsgsTypesRepo
import kotlinx.coroutines.launch

//@HiltViewModel
class MsgsTypesViewModel
//@Inject
constructor(private val msgsTypesRepo: MsgsTypesRepo) : ViewModel() {

    private val _response = MutableLiveData<List<MsgsTypesModel>>()

    val responseMsgsTypes: LiveData<List<MsgsTypesModel>>
        get() = _response

    init {
        getAllMsgsTypes()
    }

    private fun getAllMsgsTypes()  = viewModelScope.launch {
        msgsTypesRepo.getMsgsTypes_Ser().let {response ->

            Log.d("sww","dfrr")
            Log.d("sww",""+response.body())

            if (response.isSuccessful){
                 // sweilem edit
               _response.postValue(response.body()?.results)

            }
            else{
                Log.d("tag", "getAll Error: ${response.code()}")
            }
        }
    }
}




