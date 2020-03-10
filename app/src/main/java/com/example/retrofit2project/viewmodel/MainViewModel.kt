package com.example.retrofit2project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.retrofit2project.model.Quote
import com.example.retrofit2project.model.User
import com.example.retrofit2project.repository.MainRepository

class MainViewModel  : ViewModel()
{
    private val _userID : MutableLiveData<String> = MutableLiveData()
    private val _qouteID : MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations
        .switchMap(_userID)
        {
            MainRepository.getUser(it)
        }
    val quote: LiveData<Quote> = Transformations
        .switchMap(_qouteID)
        {
            MainRepository.getQoute(it)
        }

    val getAllquote : LiveData<List<Quote>> = MainRepository.getAllQuote()



    fun setUserId(user_id : String)
    {
        val update = user_id

        if (_userID.value == update)
        {
            return
        }
        _userID.value = update
    }
    fun setQuoteId(user_id : String)
    {
        val update = user_id

        if (_qouteID.value == update)
        {
            return
        }
        _qouteID.value = update
    }

    fun cancelJobs()
    {
        MainRepository.cancelJobs()
    }
}