package com.example.a01noactivityidgs9ama23

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    var dice1Number:MutableLiveData<Int> = MutableLiveData<Int>().apply{value=0}
    var dice2Number:MutableLiveData<Int> = MutableLiveData<Int>().apply{value=0}
    var username:MutableLiveData<String> =MutableLiveData<String>().apply{value=""}
    public fun getDice1Value():Int?{
        return this.dice1Number.value
    }

    public fun setDice1NumberValue(value:Int?){
        this.dice1Number.value=value
    }

    public fun getDice2Value():Int?{
        return this.dice2Number.value
    }

    public fun setDice2NumberValue(value:Int?){
        this.dice2Number.value=value
    }

    public fun getUsernameValue():String?{
        return this.username.value
    }
    public fun setUsernameValue(value:String?){
        this.username.value=value
    }

}