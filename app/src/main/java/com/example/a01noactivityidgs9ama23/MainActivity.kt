package com.example.a01noactivityidgs9ama23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.a01noactivityidgs9ama23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var model:MainActivityViewModel

    private lateinit var binding:ActivityMainBinding

    lateinit var textDice1: TextView
    lateinit var textDice2: TextView

    lateinit var imageDice1: ImageView
    lateinit var imageDice2: ImageView


    var con = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)



        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.btnRoll.setOnClickListener {
            con +=1
            roll()
        }

        model.dice1Number.observe(this,{
            binding.txtDice1.text = it.toString()
            binding.imgDice1.setImageResource(when(it){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            })
        })

        /*binding.btnReset.setOnClickListener {
            con=0
            reset()
        }

        binding.btnTimes.setOnClickListener {
            Toast.makeText(this,"Clicked $con times", Toast.LENGTH_SHORT).show()
        }*/
    }

    fun roll() {
        //textDice1= binding.txtDice1
        textDice2= binding.txtDice2

        val numDado = (1..6).random()
        model.setDice1NumberValue(numDado)


        /*val numDado2 = (1..6).random()
        textDice2.text = numDado2.toString()


        val imgDado2 = when (numDado2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        imageDice2= binding.imgDice2
        imageDice2.setImageResource(imgDado2)
   */
    }
    /*fun reset() {
        imageDice1= binding.imgDice1
        imageDice2= binding.imgDice2

        imageDice1.setImageResource(R.drawable.empty_dice)
        imageDice2.setImageResource(R.drawable.empty_dice)

        textDice1 = binding.txtDice1
        textDice2 = binding.txtDice2
        textDice1.text = "dice1"
        textDice2.text = "dice1"
        Toast.makeText(this,"Game reseted", Toast.LENGTH_SHORT).show()
    }*/
}
