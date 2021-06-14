package com.iug.qudsiapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.iug.qudsiapp.R
import com.iug.qudsiapp.databinding.ActivityMainBinding
import com.iug.qudsiapp.ui.view_models.NewsViewModel
import com.iug.qudsiapp.util.Commons
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel : NewsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragment)
        binding.bottomNav.setupWithNavController(navController)
        Commons.setLocale("ar", this)

        when (Commons.getSharedPreferences(this).getBoolean(Commons.IS_NIGHT, false)) {
            false ->
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true ->
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

//        mViewModel = ViewModelProvider(this).get(TestViewModel::class.java)
//        mViewModel.news.observe(this){newsList ->
//            Log.d("TTT","SIZE = "+newsList.size.toString())
//
//        }
//
//        GlobalScope.launch {
//           mViewModel.getNews()
//        }

    }
    suspend fun getArrFromNet(): IntArray{
        Log.e("test5","step 1")
        delay(4000)
        Log.e("test5","step 2")
        return intArrayOf(1,5)
    }
}