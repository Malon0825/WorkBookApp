package com.example.workbookapp.quizzes

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.workbookapp.R
import com.example.workbookapp.VoiceHelper
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.lessons.SyntaxActivityOne
import com.example.workbookapp.model.AnswersModel
import com.example.workbookapp.model.QuizListModel
import com.example.workbookapp.model.QuizzesModel
import com.example.workbookapp.model.ScoreModel
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Date

class QuizActivityOneOne : AppCompatActivity() {

    var dbHandler : DatabaseHelper = DatabaseHelper(this)
    var questionList : List<QuizzesModel> = ArrayList<QuizzesModel>()
    var quiz_name : String? = ""
    var topic : String? = ""
    private lateinit var playSound: VoiceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_one_one)

        quiz_name = intent.getStringExtra("quiz_name")
        topic = intent.getStringExtra("topic")

        dbHandler = DatabaseHelper(this)
        playSound = VoiceHelper(applicationContext)
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
        val buttonChoiceA = findViewById<Button>(R.id.buttonChoiceA)
        val buttonChoiceB = findViewById<Button>(R.id.buttonChoiceB)
        val buttonChoiceC = findViewById<Button>(R.id.buttonChoiceC)
        val buttonChoiceD = findViewById<Button>(R.id.buttonChoiceD)
        var questionAnswer = ""

        val currentDate = Date()

        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val dateString = dateFormat.format(currentDate)

        fun showQuestion() {
            if (currentQuestionIndex < questionList.size) {
                val question = questionList[currentQuestionIndex]

                textViewInstruction.apply {
                    text = question.instruction
                }
                textViewInstruction.setMovementMethod(ScrollingMovementMethod())

                textViewQuestion.text = question.question
                buttonChoiceA.text = question.choice_a
                buttonChoiceB.text = question.choice_b
                buttonChoiceC.text = question.choice_c
                buttonChoiceD.text = question.choice_d
                questionAnswer = question.answer
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


        buttonChoiceA.setOnClickListener {
            val question = questionList[currentQuestionIndex]
            answer.quiz_name = question.question
            answer.question = textViewQuestion.text.toString()
            answer.answer_answer = buttonChoiceA.text.toString()

            success = dbHandler?.addAnswer(answer) as Boolean

            if (success) {
                if (questionAnswer == answer.answer_answer) {
                    currentCorrectAnswerIndex++
                    playSound.playSound(true)
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    playSound.playSound(false)
                    Toast.makeText(this, "The correct answer is " + questionAnswer, Toast.LENGTH_SHORT).show()
                }
                currentQuestionIndex++
                showQuestion()
            } else {
                Toast.makeText(this, "Answer not saved.", Toast.LENGTH_SHORT).show()
            }

        }

        buttonChoiceB.setOnClickListener {
            val question = questionList[currentQuestionIndex]
            answer.quiz_name = question.question
            answer.question = textViewQuestion.text.toString()
            answer.answer_answer = buttonChoiceB.text.toString()

            success = dbHandler?.addAnswer(answer) as Boolean

            if (success) {
                if (questionAnswer == answer.answer_answer) {
                    currentCorrectAnswerIndex++
                    playSound.playSound(true)
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    playSound.playSound(false)
                    Toast.makeText(this, "The correct answer is " + questionAnswer, Toast.LENGTH_SHORT).show()
                }
                currentQuestionIndex++
                showQuestion()
            } else {
                Toast.makeText(this, "Answer not saved.", Toast.LENGTH_SHORT).show()
            }

        }

        buttonChoiceC.setOnClickListener {
            val question = questionList[currentQuestionIndex]
            answer.quiz_name = question.question
            answer.question = textViewQuestion.text.toString()
            answer.answer_answer = buttonChoiceC.text.toString()

            success = dbHandler?.addAnswer(answer) as Boolean

            if (success) {
                if (questionAnswer == answer.answer_answer) {
                    currentCorrectAnswerIndex++
                    playSound.playSound(true)
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    playSound.playSound(false)
                    Toast.makeText(this, "The correct answer is " + questionAnswer, Toast.LENGTH_SHORT).show()
                }
                currentQuestionIndex++
                showQuestion()
            } else {
                Toast.makeText(this, "Answer not saved.", Toast.LENGTH_SHORT).show()
            }

        }

        buttonChoiceD.setOnClickListener {
            val question = questionList[currentQuestionIndex]
            answer.quiz_name = question.question
            answer.question = textViewQuestion.text.toString()
            answer.answer_answer = buttonChoiceD.text.toString()

            success = dbHandler?.addAnswer(answer) as Boolean

            if (success) {
                if (questionAnswer == answer.answer_answer) {
                    currentCorrectAnswerIndex++
                    playSound.playSound(true)
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    playSound.playSound(false)
                    Toast.makeText(this, "The correct answer is " + questionAnswer, Toast.LENGTH_SHORT).show()
                }
                currentQuestionIndex++
                showQuestion()
            } else {
                Toast.makeText(this, "Answer not saved.", Toast.LENGTH_SHORT).show()
            }

        }

        showQuestion()
    }

    override fun onResume() {
        super.onResume()
        fetchList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchList(){
        questionList = dbHandler!!.getALlQuiz(quiz_name.toString(), topic.toString())
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Please finish the all the questions.", Toast.LENGTH_SHORT).show()
    }
}