package com.example.thefourfragments.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    // Step 1: MutableLiveData for displaying a custom message in the fragment
    private val _text = MutableLiveData<String>().apply {
        value = "This is Counter Fragment"
    }
    val text: LiveData<String> = _text

    // Step 2: MutableLiveData for managing the counter value
    private val _counter = MutableLiveData<Int>().apply {
        value = 0
    }
    val counter: LiveData<Int> = _counter

    // Step 3: Function to increment the counter value
    fun addCounter(amount: Int) {
        _counter.value = _counter.value?.plus(amount)
    }

    // Step 4: Function to clear the counter value
    fun clearCounter() {
        _counter.value = 0
    }
}
