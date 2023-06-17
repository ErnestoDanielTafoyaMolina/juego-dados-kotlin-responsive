package com.example.a01noactivityidgs9ama23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var con = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonroll: Button = findViewById(R.id.btn_roll)
        val buttontimes: Button = findViewById(R.id.btn_times)
        val buttonreset: Button = findViewById(R.id.btn_reset)

        val imageDice2: ImageView = findViewById(R.id.img_Dice2)

        buttonroll.setOnClickListener {
            roll()
            con += 1
        }
        buttonreset.setOnClickListener {
            reset()
            con=0
        }
        buttontimes.setOnClickListener {
            Toast.makeText(this,"Clicked $con times", Toast.LENGTH_SHORT).show()
        }
    }

    fun roll() {
        val textDice1: TextView = findViewById(R.id.txt_Dice1)
        val textDice2: TextView = findViewById(R.id.txt_Dice2)

        val numDado = (1..6).random()
        val numDado2 = (1..6).random()

        textDice1.text = numDado.toString()
        textDice2.text = numDado2.toString()

        val imgDado = when (numDado) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val imgDado2 = when (numDado2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val imageDice1: ImageView = findViewById(R.id.img_Dice1)
        imageDice1.setImageResource(imgDado)
        val imageDice2: ImageView = findViewById(R.id.img_Dice2)
        imageDice2.setImageResource(imgDado2)
    }
    fun reset() {
        val imageDice1: ImageView = findViewById(R.id.img_Dice1)
        val imageDice2: ImageView = findViewById(R.id.img_Dice2)

        imageDice1.setImageResource(R.drawable.empty_dice)
        imageDice2.setImageResource(R.drawable.empty_dice)

        val txtDice1 : TextView = findViewById(R.id.txt_Dice1)
        val txtDice2 : TextView = findViewById(R.id.txt_Dice2)
        txtDice1.text = "dice1"
        txtDice2.text = "dice1"
        Toast.makeText(this,"Game reseted", Toast.LENGTH_SHORT).show()
    }
}
