package com.example.workbookapp.quizzes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.workbookapp.R
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.model.QuizListModel
import com.example.workbookapp.model.QuizzesModel

class QuizzesActivitySyntaxOne : AppCompatActivity() {
    var dbHandler : DatabaseHelper = DatabaseHelper(this)
    var questionList : List<QuizListModel> = ArrayList<QuizListModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizzes_syntax_one)

        val topic = intent.getStringExtra("topic")

        val layout = findViewById<LinearLayout>(R.id.linearLayoutQuizList)
        dbHandler = DatabaseHelper(this)
        fetchList()

        var success = false

        for (quiz in questionList) {
            val button = Button(this)
            button.text = quiz.quiz_name
            // Add the button to a layout
            layout.addView(button)

            button.setOnClickListener {
                val intent = Intent(this, QuizModelMulChoice2::class.java)
                intent.putExtra("quiz", quiz)
                startActivity(intent)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        fetchList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchList(){
        questionList = dbHandler!!.getALlQuizList()
    }
}