package com.example.workbookapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.workbookapp.quizzes.QuizTypeActivity

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val quizAdd= findViewById<Button>(R.id.buttonAddQuiz)
        quizAdd.setOnClickListener {
            val intent = Intent(this, QuizTypeActivity::class.java)
            startActivity(intent)

        }



    }
}