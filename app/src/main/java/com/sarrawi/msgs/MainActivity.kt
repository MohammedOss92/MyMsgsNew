package com.sarrawi.msgs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sarrawi.msgs.adapter.MsgsTypes_Adapter
import com.sarrawi.msgs.api.ApiService
import com.sarrawi.msgs.databinding.ActivityMainBinding
import com.sarrawi.msgs.repository.MsgsTypesRepo
import com.sarrawi.msgs.viewModel.MsgsTypesViewModel
import com.sarrawi.msgs.viewModel.MyViewModelFactory

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MsgsTypesViewModel
    private lateinit var msgstypesAdapter: MsgsTypes_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = ApiService.provideRetrofitInstance()
        val mainRepository = MsgsTypesRepo(retrofitService)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MsgsTypesViewModel::class.java)
        setUpRv()

    }

    private fun setUpRv() {

        msgstypesAdapter = MsgsTypes_Adapter()
        binding.recyclerView.apply {
            adapter = msgstypesAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.VERTICAL,
                false
            )

            setHasFixedSize(true)
        }

        viewModel.responseMsgsTypes.observe(this, { listTvShows ->

            msgstypesAdapter.msgsTypesModel = listTvShows

        })

    }
}