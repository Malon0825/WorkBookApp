package com.example.workbookapp.lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.workbookapp.R

class LessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val syntax = findViewById<ImageButton>(R.id.imageButtonSyntax)
        syntax.setOnClickListener {
            val intent = Intent(this, SyntaxActivity::class.java)
            startActivity(intent)
        }
    }
}