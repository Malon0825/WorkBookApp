package com.example.workbookapp.lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.workbookapp.R

class MorphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morph)

        val lessonOne = findViewById<ImageButton>(R.id.imageButtonOne)
        lessonOne.setOnClickListener {
            val intent = Intent(this, MorphActivityOne::class.java)
            startActivity(intent)
        }

        val lessonTwo = findViewById<ImageButton>(R.id.imageButtonTwo)
        lessonTwo.setOnClickListener {
            val intent = Intent(this, MorphActivityTwo::class.java)
            startActivity(intent)
        }
    }
}