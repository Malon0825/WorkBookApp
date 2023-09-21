package com.example.workbookapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import com.example.workbookapp.history.HistoryActivity
import com.example.workbookapp.lessons.LessonActivity
import com.example.workbookapp.quizzes.QuizzesActivity
import com.example.workbookapp.scores.ScoresActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lessons = findViewById<ImageButton>(R.id.imageButtonLessons)
        lessons.setOnClickListener {
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
        }

        val quizzes = findViewById<ImageButton>(R.id.imageButtonQuizzes)
        quizzes.setOnClickListener {
            val intent = Intent(this, QuizzesActivity::class.java)
            startActivity(intent)
        }

        val scores = findViewById<ImageButton>(R.id.imageButtonScores)
        scores.setOnClickListener {
            val intent = Intent(this, ScoresActivity::class.java)
            startActivity(intent)
        }

        val history = findViewById<ImageButton>(R.id.imageButtonHistory)
        history.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

    }
}