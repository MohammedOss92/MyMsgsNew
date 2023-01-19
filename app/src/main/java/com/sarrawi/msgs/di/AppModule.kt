package com.sarrawi.msgs.di

import com.sarrawi.msgs.api.ApiService
import com.sarrawi.msgs.helper.Constants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//@Module
//@InstallIn(SingletonComponent::class)
object AppModule {

//   @Provides
    fun provideBaseUrl() = Constants.BASE_URL

//    @Provides
//    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}