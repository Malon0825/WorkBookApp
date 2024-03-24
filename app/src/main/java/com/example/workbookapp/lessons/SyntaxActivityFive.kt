package com.example.workbookapp.lessons

import android.app.Dialog
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

class SyntaxActivityFive : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syntax_five)

        val openLesson = OpenLessonWindow()
        var title : String
        var content : String

        // Get a reference to the TextView object
        val textView = findViewById<TextView>(R.id.textViewInstructionContent)

        // Set the properties of the TextView object
        textView.apply {
            text = getString(R.string.syntax_five_instruction) // Get the text from strings.xml
        }

        // Enable scrolling on the TextView object
        textView.setMovementMethod(ScrollingMovementMethod())


        val buttonNoun = findViewById<Button>(R.id.buttonNoun)
        buttonNoun.setOnClickListener {
            title = "Noun Phrase"
            content = getString(R.string.Noun)

            openLesson.ShowLessonDialog(this, title, content)
        }

        val buttonVerb = findViewById<Button>(R.id.buttonVerb)
        buttonVerb.setOnClickListener {
            title = "Verb Phrase"
            content = getString(R.string.Verb)

            openLesson.ShowLessonDialog(this, title, content)
        }

        val buttonPrepositional = findViewById<Button>(R.id.buttonPrepositional)
        buttonPrepositional.setOnClickListener {
            title = "Prepositional Phrase"
            content = getString(R.string.Prepositional)

            openLesson.ShowLessonDialog(this, title, content)
        }

        val buttonAdjectival = findViewById<Button>(R.id.buttonAdjectival)
        buttonAdjectival.setOnClickListener {
            title = "Adjectival Phrase"
            content = getString(R.string.Adjectival)

            openLesson.ShowLessonDialog(this, title, content)
        }

        val buttonAdverbial = findViewById<Button>(R.id.buttonAdverbial)
        buttonAdverbial.setOnClickListener {
            title = "Adverbial Phrase"
            content = getString(R.string.Adverbial)

            openLesson.ShowLessonDialog(this, title, content)
        }

        val buttonInfinitive = findViewById<Button>(R.id.buttonInfinitive)
        buttonInfinitive.setOnClickListener {
            title = "Infinitive Phrase"
            content = getString(R.string.Infinitive)

            openLesson.ShowLessonDialog(this, title, content)
        }

        val buttonParticipial = findViewById<Button>(R.id.buttonParticipial)
        buttonParticipial.setOnClickListener {
            title = "Participial Phrase"
            content = getString(R.string.Participial)

            openLesson.ShowLessonDialog(this, title, content)
        }


    }
}