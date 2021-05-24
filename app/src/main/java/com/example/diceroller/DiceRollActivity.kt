package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class DiceRollActivity : AppCompatActivity() {

    lateinit var diceImage1:ImageView
    lateinit var diceImage2:ImageView
    lateinit var diceImage3:ImageView
    lateinit var diceImage4:ImageView
    lateinit var viewResult:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            rollDice()
        }

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)
        diceImage4 = findViewById(R.id.dice_image4)
        viewResult = findViewById(R.id.tv_result)
    }

    private fun rollDice() {
        var result = 0
        var minor = 6

        for (i in 1..4) {
            var roll = Random.nextInt(6) + 1
            val drawableResource = when (roll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            when(i){
                1 -> diceImage1.setImageResource(drawableResource)
                2 -> diceImage2.setImageResource(drawableResource)
                3 -> diceImage3.setImageResource(drawableResource)
                4 -> diceImage4.setImageResource(drawableResource)
            }

            result += roll
            if(roll < minor) minor = roll
        }
        result -= minor
        viewResult.text = result.toString()
    }
}