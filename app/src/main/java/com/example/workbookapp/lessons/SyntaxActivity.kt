package com.example.workbookapp.lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.workbookapp.R

class SyntaxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syntax)

        val lessonOne = findViewById<ImageButton>(R.id.imageButtonOne)
        lessonOne.setOnClickListener {
            val intent = Intent(this, SyntaxActivityOne::class.java)
            startActivity(intent)
        }

        val lessonTwo = findViewById<ImageButton>(R.id.imageButtonTwo)
        lessonTwo.setOnClickListener {
            val intent = Intent(this, SyntaxActivityTwo::class.java)
            startActivity(intent)
        }

        val lessonThree = findViewById<ImageButton>(R.id.imageButtonThree)
        lessonThree.setOnClickListener {
            val intent = Intent(this, SyntaxActivityThree::class.java)
            startActivity(intent)
        }

        val lessonFour = findViewById<ImageButton>(R.id.imageButtonFour)
        lessonFour.setOnClickListener {
            val intent = Intent(this, SyntaxActivityFour::class.java)
            startActivity(intent)
        }

        val lessonFive = findViewById<ImageButton>(R.id.imageButtonFive)
        lessonFive.setOnClickListener {
            val intent = Intent(this, SyntaxActivityFive::class.java)
            startActivity(intent)
        }

        val lessonSix = findViewById<ImageButton>(R.id.imageButtonSix)
        lessonSix.setOnClickListener {
            val intent = Intent(this, SyntaxActivitySix::class.java)
            startActivity(intent)
        }

        val lessonSeven = findViewById<ImageButton>(R.id.imageButtonSeven)
        lessonSeven.setOnClickListener {
            val intent = Intent(this, SyntaxActivitySeven::class.java)
            startActivity(intent)
        }

    }
}