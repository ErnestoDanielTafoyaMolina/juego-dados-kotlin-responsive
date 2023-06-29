package com.example.a01noactivityidgs9ama23

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    var dice1Number:MutableLiveData<Int> = MutableLiveData<Int>().apply{value=0}

    public fun getDice1Value():Int?{
        return this.dice1Number.value
    }

    public fun setDice1NumberValue(value:Int?){
        this.dice1Number.value=value
    }
}