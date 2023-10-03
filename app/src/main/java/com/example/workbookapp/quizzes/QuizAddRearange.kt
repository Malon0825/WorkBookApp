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

    var topicGlobal  = ""
    var quizNameGlobal  = ""

    lateinit var etQuizName : EditText
    lateinit var etInstruction : EditText

    lateinit var etStatementOne : EditText
    lateinit var etStatementTwo : EditText

    lateinit var etStatementThree : EditText
    lateinit var etStatementCorrect : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_add_rearange)

        val topic = intent.getStringExtra("topic")

        dbHandler = DatabaseHelper(this)

        etInstruction = findViewById(R.id.et_quiz_instrunction)
        etQuizName = findViewById(R.id.et_quiz_name)
        etStatementOne = findViewById(R.id.et_first_statement)
        etStatementTwo = findViewById(R.id.et_second_statement)
        etStatementThree = findViewById(R.id.et_third_statement)
        etStatementCorrect = findViewById(R.id.et_answer_statement)

        val continueButton= findViewById<Button>(R.id.buttonContinue)
        continueButton.setOnClickListener {
            var success : Boolean = false
            val quiz : QuizzesRearangeModel = QuizzesRearangeModel()

            quiz.quiz_topic = topic
            quiz.instruction = etInstruction.text.toString()
            quiz.quiz_name = etQuizName.text.toString()
            quiz.quiz_statement_one = etStatementOne.text.toString()
            quiz.quiz_statement_two = etStatementTwo.text.toString()
            quiz.quiz_statement_three = etStatementThree.text.toString()
            quiz.quiz_statement_correct = etStatementCorrect.text.toString()


            if (etQuizName.text.toString().isNotEmpty()
                && etInstruction.text.toString().isNotEmpty()
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
        var successQuizList : Boolean = false
        val quizModel = QuizListModel()
        quizModel.topic_name = topicGlobal
        quizModel.quiz_name = quizNameGlobal
        quizModel.quiz_model = "QuizAddMulChoice4"

        if (etQuizName.text.toString().isNotEmpty()
            && etInstruction.text.toString().isNotEmpty()
            && etStatementOne.text.toString().isNotEmpty()
            && etStatementThree.text.toString().isNotEmpty()
            && etStatementTwo.text.toString().isNotEmpty()
            && etStatementCorrect.text.toString().isNotEmpty())
        {
            successQuizList = dbHandler?.addALlQuizList(quizModel) as Boolean

            if (successQuizList) {
                Toast.makeText(this, "Please press finish button to save the quiz.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Unsuccessful.", Toast.LENGTH_SHORT).show()
            }
        }else{
            val intent = Intent(this, QuizTypeActivity::class.java)
            startActivity(intent)
        }

    }
}