package com.example.workbookapp.lessons

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.workbookapp.R
import com.example.workbookapp.adapter.OpenLessonWindow

class SubordinatingClauses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_subordinating_clauses)

        val openLesson = OpenLessonWindow()
        var title : String
        var content : String

        val buttonAdjective = findViewById<Button>(R.id.buttonAdjective)
        buttonAdjective.setOnClickListener {
            title = "Adjective Clauses"
            content = getString(R.string.Clauses_Adjective)

            openLesson.ShowLessonDialog(this, title, content)
        }

        val buttonAdverbial = findViewById<Button>(R.id.buttonAdverbial)
        buttonAdverbial.setOnClickListener {
            title = "Adverbial Clauses"
            content = getString(R.string.Clauses_Adverbial)

            openLesson.ShowLessonDialog(this, title, content)
        }
    }
}