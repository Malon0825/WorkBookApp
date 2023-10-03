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
import com.example.workbookapp.model.QuizzesMulChoice6Model
import com.example.workbookapp.model.QuizzesMulChoice7Model

class QuizAddMulChoice7 : AppCompatActivity() {

    var dbHandler : DatabaseHelper ?= null
    var topicGlobal  = ""
    var quizNameGlobal  = ""

    lateinit var etQuizName : EditText
    lateinit var etInstruction : EditText

    lateinit var etQuestion : EditText
    lateinit var etChoiceA : EditText

    lateinit var etChoiceB : EditText
    lateinit var etChoiceC : EditText

    lateinit var etChoiceD : EditText
    lateinit var etChoiceE : EditText

    lateinit var etChoiceF : EditText
    lateinit var etChoiceG : EditText

    lateinit var etAnswer : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_add_mul_choice7)

        val topic = intent.getStringExtra("topic")

        dbHandler = DatabaseHelper(this)

        etInstruction = findViewById(R.id.et_quiz_instrunction)
        etQuizName = findViewById(R.id.et_quiz_name)
        etQuestion = findViewById(R.id.et_question)
        etChoiceA = findViewById(R.id.et_choice_a)
        etChoiceB = findViewById(R.id.et_choice_b)
        etChoiceC = findViewById(R.id.et_choice_c)
        etChoiceD = findViewById(R.id.et_choice_d)
        etChoiceE = findViewById(R.id.et_choice_e)
        etChoiceF = findViewById(R.id.et_choice_f)
        etChoiceG = findViewById(R.id.et_choice_g)
        etAnswer = findViewById(R.id.et_answer)

        val continueButton= findViewById<Button>(R.id.buttonContinue)
        continueButton.setOnClickListener {
            var success : Boolean = false
            val quiz : QuizzesMulChoice7Model = QuizzesMulChoice7Model()

            quiz.quiz_topic = topic
            quiz.instruction = etInstruction.text.toString()
            quiz.quiz_name = etQuizName.text.toString()
            quiz.question = etQuestion.text.toString()
            quiz.choice_a = etChoiceA.text.toString()
            quiz.choice_b = etChoiceB.text.toString()
            quiz.choice_c = etChoiceC.text.toString()
            quiz.choice_d = etChoiceD.text.toString()
            quiz.choice_e = etChoiceE.text.toString()
            quiz.choice_f = etChoiceF.text.toString()
            quiz.choice_g = etChoiceG.text.toString()
            quiz.answer = etAnswer.text.toString()

            if (etQuizName.text.toString().isNotEmpty()
                && etInstruction.text.toString().isNotEmpty()
                && etQuestion.text.toString().isNotEmpty()
                && etChoiceA.text.toString().isNotEmpty()
                && etChoiceB.text.toString().isNotEmpty()
                && etChoiceC.text.toString().isNotEmpty()
                && etChoiceD.text.toString().isNotEmpty()
                && etChoiceE.text.toString().isNotEmpty()
                && etChoiceF.text.toString().isNotEmpty()
                && etChoiceG.text.toString().isNotEmpty()
                && etAnswer.text.toString().isNotEmpty())
            {
                success = dbHandler?.addQuizMulChoice7(quiz) as Boolean

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
            quizModel.quiz_model = "QuizAddMulChoice7"
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
            && etQuestion.text.toString().isNotEmpty()
            && etChoiceA.text.toString().isNotEmpty()
            && etChoiceB.text.toString().isNotEmpty()
            && etChoiceC.text.toString().isNotEmpty()
            && etChoiceD.text.toString().isNotEmpty()
            && etChoiceE.text.toString().isNotEmpty()
            && etChoiceF.text.toString().isNotEmpty()
            && etChoiceG.text.toString().isNotEmpty()
            && etAnswer.text.toString().isNotEmpty())
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