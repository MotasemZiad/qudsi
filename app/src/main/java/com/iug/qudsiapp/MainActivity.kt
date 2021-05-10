package com.iug.qudsiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iug.qudsiapp.data.firebase.FirestoreRepository
import com.iug.qudsiapp.view_models.TestViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var mViewModel : TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider(this).get(TestViewModel::class.java)
        mViewModel.news.observe(this){newsList ->
            Log.d("TTT","SIZE = "+newsList.size.toString())

        }

        GlobalScope.launch {
           mViewModel.getNews()
        }

    }
    suspend fun getArrFromNet(): IntArray{
        Log.e("test5","step 1")
        delay(4000)
        Log.e("test5","step 2")
        return intArrayOf(1,5)
    }
}