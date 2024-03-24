package com.example.workbookapp.lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import com.example.workbookapp.R

class   MorphActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morph_one)

        // Get a reference to the TextView object
        val textView = findViewById<TextView>(R.id.textViewInstructionContent)

        // Set the properties of the TextView object
        textView.apply {
            text = getString(R.string.morph_one_instruction) // Get the text from strings.xml
        }

        // Enable scrolling on the TextView object
        textView.setMovementMethod(ScrollingMovementMethod())



        val oneOne = findViewById<Button>(R.id.buttonOne)
        oneOne.setOnClickListener {
            val intent = Intent(this, FreeBoundMorphemes::class.java)
            startActivity(intent)
        }

        val buttonTwo = findViewById<Button>(R.id.buttonTwo)
        buttonTwo.setOnClickListener {
            val intent = Intent(this, InflectionalDerivationalMorphemes::class.java)
            startActivity(intent)
        }

        val buttonThree = findViewById<Button>(R.id.buttonThree)
        buttonThree.setOnClickListener {
            val intent = Intent(this, MorphPrincipal::class.java)
            startActivity(intent)
        }



    }
}