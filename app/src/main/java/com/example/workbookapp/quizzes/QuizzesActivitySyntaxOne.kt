package com.example.workbookapp.quizzes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.workbookapp.R

class QuizzesActivitySyntaxOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizzes_syntax_one)

        val quiz1 = findViewById<Button>(R.id.buttonOne)
        quiz1.setOnClickListener {
            val intent = Intent(this, QuizActivityOneOne::class.java)
            startActivity(intent)
        }
    }
}