package com.example.thefourfragments.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Counter Fragment"
    }
    val text: LiveData<String> = _text

    private val _counter = MutableLiveData<Int>().apply {
        value = 0
    }

    val counter: LiveData<Int> = _counter

    fun addCounter(amount: Int) = _counter.postValue(counter.value?.plus(amount))
    fun clearCounter() = _counter.postValue(0)

}