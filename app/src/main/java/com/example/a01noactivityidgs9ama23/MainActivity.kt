package com.example.a01noactivityidgs9ama23

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.a01noactivityidgs9ama23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var model:MainActivityViewModel

    private lateinit var binding:ActivityMainBinding

    //var con = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)



        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        if(model.getUsernameValue().isNullOrEmpty()){
            binding.edtUsername.visibility=View.VISIBLE
            binding.btnUsername.visibility=View.VISIBLE
            binding.tvUsername.visibility=View.GONE
        }else{
            binding.edtUsername.visibility=View.GONE
            binding.btnUsername.visibility=View.GONE
            binding.tvUsername.visibility=View.VISIBLE
        }

        binding.btnRoll.setOnClickListener {
            //con +=1
            model.setTimes(model.getTimes()?.plus(1))
            roll()
        }

        model.dice1Number.observe(this,){
            binding.txtDice1.text = it.toString()
            binding.imgDice1.setImageResource(when(it){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            })
        }
        model.dice2Number.observe(this,){
           binding.txtDice2.text=it.toString()
            binding.imgDice2.setImageResource(when(it){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            })
        }

       model.username.observe(this,){
            binding.tvUsername.text =it.toString()
        }

       binding.btnUsername?.setOnClickListener{
            addUsername(it)
        }
        binding.tvUsername?.setOnClickListener{
            updateUsername(it)
        }
        binding.btnReset.setOnClickListener {
            model.setTimes(0)
            //con=0
            reset()
        }
        binding.btnTimes.setOnClickListener {
            Toast.makeText(this,"Clicked ${model.getTimes()} times", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addUsername(view: View?) {
        binding.tvUsername?.text=binding.edtUsername?.text
        model.setUsernameValue(binding.tvUsername?.text.toString())
        binding.edtUsername?.visibility=View.GONE
       view?.visibility=View.GONE
        binding.tvUsername?.visibility=View.VISIBLE
        val inputMethodManager=getSystemService((Context.INPUT_METHOD_SERVICE)) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken,0)
    }

    private fun updateUsername(view: View?){
        binding.edtUsername?.visibility=View.VISIBLE
        binding.btnUsername?.visibility=View.VISIBLE
        view?.visibility=View.GONE
        binding.edtUsername?.requestFocus()
        val showKbd=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        showKbd.showSoftInput(binding.edtUsername,0)
    }

    fun roll() {
        val numDado1 = (1..6).random()
        model.setDice1NumberValue(numDado1)

        val numDado2 = (1..6).random()
        model.setDice2NumberValue(numDado2)

    }
    fun reset() {
        model.setDice1NumberValue(0)
        model.setDice2NumberValue(0)
        Toast.makeText(this,"Game reseted", Toast.LENGTH_SHORT).show()
    }
}
