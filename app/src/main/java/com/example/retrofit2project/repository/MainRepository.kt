package com.example.retrofit2project.repository

import androidx.lifecycle.LiveData
import com.example.retrofit2project.api.RetrofitBuilder
import com.example.retrofit2project.api.RetrofitBuilderForQuote
import com.example.retrofit2project.model.Quote
import com.example.retrofit2project.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MainRepository {

    //coroutines
    var job : CompletableJob? = null
    fun getUser(user_id : String): LiveData<User>
    {
        job = Job()
        return object : LiveData<User>()
        {
            override fun onActive() {
                super.onActive()

                job?.let{ theJob->
                    CoroutineScope(IO + theJob).launch {
                        val user = RetrofitBuilder.apiService.getUser(user_id)
                        withContext(Main)
                        {
                            value = user
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }


    fun getQoute(user_id : String): LiveData<Quote>
    {
        job = Job()
        return object : LiveData<Quote>()
        {
            override fun onActive() {
                super.onActive()

                job?.let{ theJob->
                    CoroutineScope(IO + theJob).launch {
                        val user = RetrofitBuilderForQuote.apiService.getQuote(user_id)
                        withContext(Main)
                        {
                            value = user
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }

    fun getAllQuote() : LiveData<List<Quote>>
    {
        job = Job()
        return object : LiveData<List<Quote>>()
        {
            override fun onActive() {
                super.onActive()

                job?.let{ theJob->
                    CoroutineScope(IO + theJob).launch {
                        val user = RetrofitBuilderForQuote.apiService.getAllQuote()
                        withContext(Main)
                        {
                            value = user
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs()
    {
        job?.cancel()
    }
}
