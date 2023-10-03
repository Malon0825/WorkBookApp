package com.example.workbookapp.quizzes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.workbookapp.MainActivity
import com.example.workbookapp.R

class QuizzesActivityMorph : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizzes_morph)

        val quizOne= findViewById<ImageButton>(R.id.imageButtonOne)
        quizOne.setOnClickListener {
            val passData = "Syntax Topic 8"
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            intent.putExtra("topic", passData)
            startActivity(intent)
        }

        val quizTwo= findViewById<ImageButton>(R.id.imageButtonTwo)
        quizTwo.setOnClickListener {
            val passData = "Syntax Topic 9"
            val intent = Intent(this, QuizzesActivitySyntaxOne::class.java)
            intent.putExtra("topic", passData)
            startActivity(intent)
        }

    }
    override fun onBackPressed() {
        val intent = Intent(this, QuizzesActivity::class.java)
        startActivity(intent)

    }
}