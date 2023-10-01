package com.example.workbookapp.quizzes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.withStyledAttributes
import com.example.workbookapp.R
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.model.QuizListModel
import com.example.workbookapp.model.QuizzesModel

class QuizzesActivitySyntaxOne : AppCompatActivity() {
    var dbHandler : DatabaseHelper = DatabaseHelper(this)
    var questionList : List<QuizListModel> = ArrayList<QuizListModel>()
    var topic : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizzes_syntax_one)
        topic = intent.getStringExtra("topic")

        val layout = findViewById<LinearLayout>(R.id.linearLayoutQuizList)
        dbHandler = DatabaseHelper(this)
        fetchList()

        var success = false

        // Iterate over each quiz in the questionList
        for (quiz in questionList) {

//            val button = Button(this@QuizzesActivitySyntaxOne, null, R.style.ButtonStyleQuizName).apply {
//                text = quiz.quiz_name
//            }
            val button = Button(this).apply {
                text = quiz.quiz_name
            }

            layout.addView(button)

            // Set an OnClickListener for the button based on the quiz model
            when (quiz.quiz_model) {
                "QuizAddMulChoice2" -> {
                    button.setOnClickListener {
                        val intent = Intent(this, QuizModelMulChoice2::class.java)
                        intent.putExtra("quiz", quiz)
                        intent.putExtra("topic", topic)
                        intent.putExtra("quiz_name", quiz.quiz_name)
                        startActivity(intent)
                    }
                }
                "QuizAddMulChoice4" -> {
                    button.setOnClickListener {
                        val intent = Intent(this, QuizActivityOneOne::class.java)
                        intent.putExtra("quiz", quiz)
                        intent.putExtra("topic", topic)
                        intent.putExtra("quiz_name", quiz.quiz_name)
                        startActivity(intent)
                    }
                }
                "QuizAddMulChoice6" -> {
                    button.setOnClickListener {
                        val intent = Intent(this, QuizModelMulChoice6::class.java)
                        intent.putExtra("quiz", quiz)
                        intent.putExtra("topic", topic)
                        intent.putExtra("quiz_name", quiz.quiz_name)
                        startActivity(intent)
                    }
                }
                "QuizAddMulChoice7" -> {
                    button.setOnClickListener {
                        val intent = Intent(this, QuizModelMulChoice7::class.java)
                        intent.putExtra("quiz", quiz)
                        intent.putExtra("topic", topic)
                        intent.putExtra("quiz_name", quiz.quiz_name)
                        startActivity(intent)
                    }
                }
                "QuizAddRearrange" -> {
                    button.setOnClickListener {
                        val intent = Intent(this, QuizModelRearrange::class.java)
                        intent.putExtra("quiz", quiz)
                        intent.putExtra("topic", topic)
                        intent.putExtra("quiz_name", quiz.quiz_name)
                        startActivity(intent)
                    }
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        fetchList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchList(){
        questionList = dbHandler!!.getALlQuizList(topic.toString())
    }
}