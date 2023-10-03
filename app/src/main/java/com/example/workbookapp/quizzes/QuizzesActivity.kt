package com.example.workbookapp.quizzes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.workbookapp.MainActivity
import com.example.workbookapp.R

class QuizzesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizzes)

        val syntaxQuizzes = findViewById<ImageButton>(R.id.imageButtonSyntax)
        syntaxQuizzes.setOnClickListener {
            val intent = Intent(this, QuizzesActivitySyntax::class.java)
            startActivity(intent)
        }

        val morphQuizzes = findViewById<ImageButton>(R.id.imageButtonMorph)
        morphQuizzes.setOnClickListener {
            val intent = Intent(this, QuizzesActivityMorph::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}