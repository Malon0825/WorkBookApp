package com.example.workbookapp.quizzes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.workbookapp.R
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.model.QuizzesModel

class QuizAddActivity : AppCompatActivity() {

    var dbHandler : DatabaseHelper ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_add)

        val topic = intent.getStringExtra("topic")

        dbHandler = DatabaseHelper(this)

        val etQuizName = findViewById<EditText>(R.id.et_quiz_name)
        val etQuestion = findViewById<EditText>(R.id.et_question)
        val etChoiceA = findViewById<EditText>(R.id.et_choice_a)
        val etChoiceB = findViewById<EditText>(R.id.et_choice_b)
        val etChoiceC = findViewById<EditText>(R.id.et_choice_c)
        val etChoiceD = findViewById<EditText>(R.id.et_choice_d)
        val etAnswer = findViewById<EditText>(R.id.et_answer)

        val continueButton= findViewById<Button>(R.id.buttonContinue)
        continueButton.setOnClickListener {
            var success : Boolean = false
            val quiz : QuizzesModel = QuizzesModel()

            quiz.quiz_topic = topic
            quiz.quiz_name = etQuizName.text.toString()
            quiz.question = etQuestion.text.toString()
            quiz.choice_a = etChoiceA.text.toString()
            quiz.choice_b = etChoiceB.text.toString()
            quiz.choice_c = etChoiceC.text.toString()
            quiz.choice_d = etChoiceD.text.toString()
            quiz.answer = etAnswer.text.toString()



            if (etQuizName.text.toString().isNotEmpty()
                && etQuestion.text.toString().isNotEmpty()
                && etChoiceA.text.toString().isNotEmpty()
                && etChoiceB.text.toString().isNotEmpty()
                && etChoiceC.text.toString().isNotEmpty()
                && etChoiceD.text.toString().isNotEmpty()
                && etAnswer.text.toString().isNotEmpty())
            {
                success = dbHandler?.addQuiz(quiz) as Boolean

                if (success) {
                    etQuestion.setText("")
                    etAnswer.setText("")
                    Toast.makeText(this, "Question added successfully.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Unsuccessful.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Please make sure all the fields are not empty!!", Toast.LENGTH_LONG).show()
            }

        }
    }
}