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

        val quiz1= findViewById<ImageButton>(R.id.imageButtonOne)
        quiz1.setOnClickListener {
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            startActivity(intent)
        }
    }
}