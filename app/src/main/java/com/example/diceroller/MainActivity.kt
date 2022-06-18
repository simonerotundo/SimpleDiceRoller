package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Classe Dice
    class Dice() {

        fun roll(): Int {
            return (1..6).random()
        }

    }

    // Default method onCreate
    override fun onCreate(savedInstanceState: Bundle?) {

        // default
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // array of all images that i'll use for representing all the 6 faces of the dice
        val img = intArrayOf(R.drawable.nullimg, R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6)

        // my items
        val textView: TextView = findViewById(R.id.textView)
        val rollButton: Button = findViewById(R.id.rollButton)
        val imageView: ImageView = findViewById(R.id.imageView)

        // default text and image (on create)
        textView.text = "^-^"                                           // welcome text
        imageView.setImageDrawable(getResources().getDrawable(img[0]))  // full transparent image

        // button (on click)
        rollButton.setOnClickListener {
            val gen: Int = rollDice()                                           // generates a random value from 1 to 6 ..
            imageView.setImageDrawable(getResources().getDrawable(img[gen]))    // .. switch image dinamically
        }

    }

    private fun rollDice() : Int {

        val dice = Dice()
        val diceRoll = dice.roll()
        val resultView: TextView = findViewById(R.id.textView)
        resultView.text = diceRoll.toString()

        return diceRoll

    }


}