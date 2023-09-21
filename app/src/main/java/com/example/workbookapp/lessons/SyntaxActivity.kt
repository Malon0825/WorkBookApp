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
    }
}