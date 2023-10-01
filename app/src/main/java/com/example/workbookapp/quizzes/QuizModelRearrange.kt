package com.example.workbookapp.quizzes

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.workbookapp.R
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.model.AnswersModel
import com.example.workbookapp.model.QuizzesMulChoice2Model
import com.example.workbookapp.model.QuizzesRearangeModel
import com.example.workbookapp.model.ScoreModel
import java.text.SimpleDateFormat
import java.util.Date

class QuizModelRearrange : AppCompatActivity() {

    var dbHandler : DatabaseHelper = DatabaseHelper(this)
    var questionList : List<QuizzesRearangeModel> = ArrayList<QuizzesRearangeModel>()
    private var correctSound : MediaPlayer?= null
    private var wrongSound : MediaPlayer?= null
    var quiz_name : String? = ""
    var topic : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_model_rearrange)

        quiz_name = intent.getStringExtra("quiz_name")
        topic = intent.getStringExtra("topic")

        correctSound = MediaPlayer.create(this, R.raw.correct)
        wrongSound = MediaPlayer.create(this, R.raw.wrong)

        dbHandler = DatabaseHelper(this)
        fetchList()
        var currentQuestionIndex = 0
        var currentCorrectAnswerIndex = 0

        var success: Boolean = false
        var successAddScore: Boolean = false
        val answer: AnswersModel = AnswersModel()
        val score: ScoreModel = ScoreModel()


        var quizName = ""
        val textViewQuestion = findViewById<TextView>(R.id.textViewQuestion)
        val textViewInstruction = findViewById<TextView>(R.id.textViewInstruction)
        val editTextAnswer = findViewById<EditText>(R.id.et_answer_statement)
        var questionAnswer = ""

        val currentDate = Date()

        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val dateString = dateFormat.format(currentDate)




        fun showQuestion() {
            if (currentQuestionIndex < questionList.size) {
                val question = questionList[currentQuestionIndex]
                textViewInstruction.text = question.instruction
                Log.e("DBHelper", question.instruction)
                Log.e("DBHelper", question.quiz_statement_one)
                Log.e("DBHelper", question.quiz_statement_two)
                Log.e("DBHelper", question.quiz_statement_three)

                val rearrange = question.quiz_statement_one + "/" + question.quiz_statement_two + "/" + question.quiz_statement_three
                textViewQuestion.text = rearrange
                questionAnswer = question.quiz_statement_correct
                quizName = question.quiz_name
            } else {
                score.quiz_name = quizName
                score.score = currentCorrectAnswerIndex.toString()
                score.dateTaken = dateString


                successAddScore = dbHandler?.addScore(score) as Boolean
                if (successAddScore){
                    val dialogBinding = layoutInflater.inflate(R.layout.activity_scores_taken, null)

                    val myDialog = Dialog(this)
                    myDialog.setContentView(dialogBinding)

                    val window = myDialog.window
                    window?.setGravity(Gravity.CENTER)
                    window?.setDimAmount(0.6F)

                    myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    myDialog.setCanceledOnTouchOutside(true)
                    myDialog.show()

                    val textscore = dialogBinding.findViewById<TextView>(R.id.textViewScore)
                    textscore.text = currentCorrectAnswerIndex.toString() + "/" + currentQuestionIndex.toString()

                    val buttonContinue = dialogBinding.findViewById<Button>(R.id.buttonContinue)
                    buttonContinue.setOnClickListener {
                        val intent = Intent(this, QuizzesActivitySyntax::class.java)
                        startActivity(intent)
                    }

                }else{
                    Toast.makeText(this, "Score not save!!", Toast.LENGTH_SHORT).show()
                }

            }

        }

        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        buttonSubmit.setOnClickListener {
            val question = questionList[currentQuestionIndex]
            val answerString = editTextAnswer.text.toString()

            if (questionAnswer == answerString) {
                currentCorrectAnswerIndex++
                correctSound?.start()
                Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
            }else{
                wrongSound?.start()
                Toast.makeText(this, "The correct answer is " + questionAnswer, Toast.LENGTH_SHORT).show()
            }
            currentQuestionIndex++
            showQuestion()

        }



        showQuestion()
    }

    override fun onResume() {
        super.onResume()
        fetchList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchList(){
        questionList = dbHandler!!.getQuizRearrange(quiz_name.toString(), topic.toString())
    }
}