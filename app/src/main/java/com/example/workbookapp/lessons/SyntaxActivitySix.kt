package com.example.workbookapp.lessons

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import com.example.workbookapp.R
import com.example.workbookapp.adapter.OpenLessonWindow

class SyntaxActivitySix : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syntax_six)

        // Get a reference to the TextView object
        val textView = findViewById<TextView>(R.id.textViewInstructionContent)
        val openLesson = OpenLessonWindow()
        var title : String
        var content : String
        // Set the properties of the TextView object
        textView.apply {
            text = getString(R.string.syntax_six_instruction) // Get the text from strings.xml
        }

        // Enable scrolling on the TextView object
        textView.setMovementMethod(ScrollingMovementMethod())

        val buttonMain = findViewById<Button>(R.id.buttonMain)
        buttonMain.setOnClickListener {
            title = "Main Clauses"
            content = getString(R.string.Clauses_Main)

            openLesson.ShowLessonDialog(this, title, content)
        }

        val buttonSubordinating = findViewById<Button>(R.id.buttonSubordinating)
        buttonSubordinating.setOnClickListener {
            val intent = Intent(this, SubordinatingClauses::class.java)
            startActivity(intent)
        }

        val buttonNoun = findViewById<Button>(R.id.buttonNoun)
        buttonNoun.setOnClickListener {
            title = "Noun Clause"
            content = getString(R.string.Clauses_Noun)

            openLesson.ShowLessonDialog(this, title, content)
        }

    }
}