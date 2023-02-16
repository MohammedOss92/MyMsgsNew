package com.sarrawi.msgs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sarrawi.msgs.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val retrofitService = ApiService.provideRetrofitInstance()
//        val mainRepository = MsgsTypesRepo(retrofitService)//, LocaleSource(this))
        //  supportActionBar?.hide()

//        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MsgsTypesViewModel::class.java)
//
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//
//        val navController = navHostFragment.navController
    }
}