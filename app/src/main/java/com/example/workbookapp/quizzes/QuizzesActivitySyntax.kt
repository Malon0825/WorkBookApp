package com.example.workbookapp.quizzes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.workbookapp.R

class QuizzesActivitySyntax : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizzes_syntax)

        val quizOne= findViewById<ImageButton>(R.id.imageButtonOne)
        quizOne.setOnClickListener {
            val passData = "Syntax Topic 1"
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            intent.putExtra("topic", passData)
            startActivity(intent)
        }

        val quizTwo= findViewById<ImageButton>(R.id.imageButtonTwo)
        quizTwo.setOnClickListener {
            val passData = "Syntax Topic 2"
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            intent.putExtra("topic", passData)
            startActivity(intent)
        }

        val quizThree= findViewById<ImageButton>(R.id.imageButtonThree)
        quizThree.setOnClickListener {
            val passData = "Syntax Topic 3"
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            intent.putExtra("topic", passData)
            startActivity(intent)
        }

        val quizFour= findViewById<ImageButton>(R.id.imageButtonFour)
        quizFour.setOnClickListener {
            val passData = "Syntax Topic 4"
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            intent.putExtra("topic", passData)
            startActivity(intent)
        }

        val quizFive= findViewById<ImageButton>(R.id.imageButtonFive)
        quizFive.setOnClickListener {
            val passData = "Syntax Topic 5"
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            intent.putExtra("topic", passData)
            startActivity(intent)
        }

        val quizSix= findViewById<ImageButton>(R.id.imageButtonSix)
        quizSix.setOnClickListener {
            val passData = "Syntax Topic 6"
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            intent.putExtra("topic", passData)
            startActivity(intent)
        }

        val quizSeven= findViewById<ImageButton>(R.id.imageButtonSeven)
        quizSeven.setOnClickListener {
            val passData = "Syntax Topic 7"
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            intent.putExtra("topic", passData)
            startActivity(intent)
        }

    }
}