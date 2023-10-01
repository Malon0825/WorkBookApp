package com.example.workbookapp.quizzes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.workbookapp.R
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.model.QuizListModel
import com.example.workbookapp.model.QuizzesMulChoice2Model
import com.example.workbookapp.model.QuizzesMulChoice6Model

class QuizAddMulChoice2 : AppCompatActivity() {

    var dbHandler : DatabaseHelper ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_add_mul_choice2)

        val topic = intent.getStringExtra("topic")

        dbHandler = DatabaseHelper(this)

        val etInstruction = findViewById<EditText>(R.id.et_quiz_instrunction)
        val etQuizName = findViewById<EditText>(R.id.et_quiz_name)
        val etQuestion = findViewById<EditText>(R.id.et_question)
        val etChoiceA = findViewById<EditText>(R.id.et_choice_a)
        val etChoiceB = findViewById<EditText>(R.id.et_choice_b)
        val etAnswer = findViewById<EditText>(R.id.et_answer)

        val continueButton= findViewById<Button>(R.id.buttonContinue)
        continueButton.setOnClickListener {
            var success : Boolean = false

            val quiz = QuizzesMulChoice2Model()
            quiz.quiz_topic = topic
            quiz.instruction = etInstruction.text.toString()
            quiz.quiz_name = etQuizName.text.toString()
            quiz.question = etQuestion.text.toString()
            quiz.choice_a = etChoiceA.text.toString()
            quiz.choice_b = etChoiceB.text.toString()
            quiz.answer = etAnswer.text.toString()



            if (etQuizName.text.toString().isNotEmpty()
                && etInstruction.text.toString().isNotEmpty()
                && etQuestion.text.toString().isNotEmpty()
                && etChoiceA.text.toString().isNotEmpty()
                && etChoiceB.text.toString().isNotEmpty()
                && etAnswer.text.toString().isNotEmpty())
            {
                success = dbHandler?.addQuizMulChoice2(quiz) as Boolean

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

        val finishButton= findViewById<Button>(R.id.buttonFinish)
        finishButton.setOnClickListener {

            var successQuizList : Boolean = false
            val quizModel = QuizListModel()
            quizModel.topic_name = topic
            quizModel.quiz_name = etQuizName.text.toString()
            quizModel.quiz_model = "QuizAddMulChoice2"
            successQuizList = dbHandler?.addALlQuizList(quizModel) as Boolean

            if (successQuizList) {
                Toast.makeText(this, "Quiz has been saved.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, QuizTypeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Unsuccessful.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, QuizTypeActivity::class.java)
                startActivity(intent)
            }

        }
    }
    override fun onBackPressed() {
        Toast.makeText(this, "Please press finish button to save the quiz.", Toast.LENGTH_LONG).show()
    }
}