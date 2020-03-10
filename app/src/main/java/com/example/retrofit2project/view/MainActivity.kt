package com.example.retrofit2project.view

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit2project.R
import com.example.retrofit2project.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.user.observe(this, Observer {
            d("MainActivity", "${it}")
        })
        viewModel.quote.observe(this, Observer {
            d("MainActivity-Quote", "${it}")
        })

        viewModel.setUserId("1")
        viewModel.setQuoteId("5")

        viewModel.getAllquote.observe(this, Observer {
            d("MainActivity-ALlQuote", "${it}")
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}
