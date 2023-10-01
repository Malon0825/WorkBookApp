package com.example.workbookapp.quizzes

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.workbookapp.R
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.model.AnswersModel
import com.example.workbookapp.model.QuizzesMulChoice6Model
import com.example.workbookapp.model.QuizzesMulChoice7Model
import com.example.workbookapp.model.ScoreModel
import java.text.SimpleDateFormat
import java.util.Date

class QuizModelMulChoice7 : AppCompatActivity() {

    var dbHandler : DatabaseHelper = DatabaseHelper(this)
    var questionList : List<QuizzesMulChoice7Model> = ArrayList<QuizzesMulChoice7Model>()
    private var correctSound : MediaPlayer?= null
    private var wrongSound : MediaPlayer?= null

    var quiz_name : String? = ""
    var topic : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_model_mul_choice7)

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
        val buttonChoiceA = findViewById<Button>(R.id.buttonChoiceA)
        val buttonChoiceB = findViewById<Button>(R.id.buttonChoiceB)
        val buttonChoiceC = findViewById<Button>(R.id.buttonChoiceC)
        val buttonChoiceD = findViewById<Button>(R.id.buttonChoiceD)
        val buttonChoiceE = findViewById<Button>(R.id.buttonChoiceE)
        val buttonChoiceF = findViewById<Button>(R.id.buttonChoiceF)
        val buttonChoiceG = findViewById<Button>(R.id.buttonChoiceG)
        var questionAnswer = ""

        val currentDate = Date()

        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val dateString = dateFormat.format(currentDate)




        fun showQuestion() {
            if (currentQuestionIndex < questionList.size) {
                val question = questionList[currentQuestionIndex]
                textViewQuestion.text = question.question
                textViewInstruction.text = question.question
                buttonChoiceA.text = question.choice_a
                buttonChoiceB.text = question.choice_b
                buttonChoiceC.text = question.choice_c
                buttonChoiceD.text = question.choice_d
                buttonChoiceE.text = question.choice_e
                buttonChoiceF.text = question.choice_f
                buttonChoiceG.text = question.choice_g
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
                    correctSound?.start()
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    wrongSound?.start()
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
                    correctSound?.start()
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    wrongSound?.start()
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
                    correctSound?.start()
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    wrongSound?.start()
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
                    correctSound?.start()
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    wrongSound?.start()
                    Toast.makeText(this, "The correct answer is " + questionAnswer, Toast.LENGTH_SHORT).show()
                }
                currentQuestionIndex++
                showQuestion()
            } else {
                Toast.makeText(this, "Answer not saved.", Toast.LENGTH_SHORT).show()
            }

        }

        buttonChoiceE.setOnClickListener {
            val question = questionList[currentQuestionIndex]
            answer.quiz_name = question.question
            answer.question = textViewQuestion.text.toString()
            answer.answer_answer = buttonChoiceE.text.toString()

            success = dbHandler?.addAnswer(answer) as Boolean

            if (success) {
                if (questionAnswer == answer.answer_answer) {
                    currentCorrectAnswerIndex++
                    correctSound?.start()
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    wrongSound?.start()
                    Toast.makeText(this, "The correct answer is " + questionAnswer, Toast.LENGTH_SHORT).show()
                }
                currentQuestionIndex++
                showQuestion()
            } else {
                Toast.makeText(this, "Answer not saved.", Toast.LENGTH_SHORT).show()
            }

        }

        buttonChoiceF.setOnClickListener {
            val question = questionList[currentQuestionIndex]
            answer.quiz_name = question.question
            answer.question = textViewQuestion.text.toString()
            answer.answer_answer = buttonChoiceF.text.toString()

            success = dbHandler?.addAnswer(answer) as Boolean

            if (success) {
                if (questionAnswer == answer.answer_answer) {
                    currentCorrectAnswerIndex++
                    correctSound?.start()
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    wrongSound?.start()
                    Toast.makeText(this, "The correct answer is " + questionAnswer, Toast.LENGTH_SHORT).show()
                }
                currentQuestionIndex++
                showQuestion()
            } else {
                Toast.makeText(this, "Answer not saved.", Toast.LENGTH_SHORT).show()
            }

        }

        buttonChoiceG.setOnClickListener {
            val question = questionList[currentQuestionIndex]
            answer.quiz_name = question.question
            answer.question = textViewQuestion.text.toString()
            answer.answer_answer = buttonChoiceG.text.toString()

            success = dbHandler?.addAnswer(answer) as Boolean

            if (success) {
                if (questionAnswer == answer.answer_answer) {
                    currentCorrectAnswerIndex++
                    correctSound?.start()
                    Toast.makeText(this, "Your answer is correct.", Toast.LENGTH_SHORT).show()
                }else{
                    wrongSound?.start()
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
        questionList = dbHandler!!.getALlQuizModel7(quiz_name.toString(), topic.toString())
    }
}