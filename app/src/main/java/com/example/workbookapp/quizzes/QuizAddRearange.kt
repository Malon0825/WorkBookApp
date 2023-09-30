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
import com.example.workbookapp.model.QuizzesModel
import com.example.workbookapp.model.QuizzesRearangeModel

class QuizAddRearange : AppCompatActivity() {

    var dbHandler : DatabaseHelper?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_add_rearange)

        val topic = intent.getStringExtra("topic")

        dbHandler = DatabaseHelper(this)

        val etQuizName = findViewById<EditText>(R.id.et_quiz_name)
        val etStatementOne = findViewById<EditText>(R.id.et_first_statement)
        val etStatementTwo = findViewById<EditText>(R.id.et_second_statement)
        val etStatementThree = findViewById<EditText>(R.id.et_third_statement)
        val etStatementCorrect = findViewById<EditText>(R.id.et_answer_statement)

        val continueButton= findViewById<Button>(R.id.buttonContinue)
        continueButton.setOnClickListener {
            var success : Boolean = false
            val quiz : QuizzesRearangeModel = QuizzesRearangeModel()

            quiz.quiz_topic = topic
            quiz.quiz_name = etQuizName.text.toString()
            quiz.quiz_statement_one = etStatementOne.toString()
            quiz.quiz_statement_two = etStatementTwo.toString()
            quiz.quiz_statement_three = etStatementThree.toString()
            quiz.quiz_statement_correct = etStatementCorrect.toString()


            if (etQuizName.text.toString().isNotEmpty()
                && etStatementOne.text.toString().isNotEmpty()
                && etStatementThree.text.toString().isNotEmpty()
                && etStatementTwo.text.toString().isNotEmpty()
                && etStatementCorrect.text.toString().isNotEmpty())
            {
                success = dbHandler?.addQuizRearrange(quiz) as Boolean

                if (success) {
                    etStatementOne.setText("")
                    etStatementTwo.setText("")
                    etStatementThree.setText("")
                    etStatementCorrect.setText("")
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
            quizModel.quiz_model = "QuizAddRearrange"
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
        Toast.makeText(this, "Please press finish button to save the quiz.", Toast.LENGTH_LONG)
            .show()
    }
}