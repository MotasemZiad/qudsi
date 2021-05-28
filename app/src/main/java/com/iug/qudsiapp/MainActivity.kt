package com.iug.qudsiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.lifecycle.ViewModelProvider
import com.iug.qudsiapp.data.retrofit.repository.NewsRepository
import com.iug.qudsiapp.data.retrofit.repository.NewsViewModelFactory
import com.iug.qudsiapp.view_models.NewsViewModelRetrofit
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var mViewModel: NewsViewModelRetrofit
    lateinit var factory: NewsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        factory = NewsViewModelFactory(NewsRepository())
        mViewModel = ViewModelProvider(this, factory).get(NewsViewModelRetrofit::class.java)
        mViewModel.getNews()



        mViewModel._myResponse.observe(this,
            {response ->
                if (response.isSuccessful){
                    Log.e("TTT",response.body()!!.articles[5].content + "\n "+ response.body()!!.articles[5].description )
                }else{
                    Log.e("TTT","The error is -> "+response.errorBody().toString())
                    Log.e("TTT","The code is -> "+response.code())

                }
            })


    }
}