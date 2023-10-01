package com.example.workbookapp.scores

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.workbookapp.R
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.model.QuizzesModel
import com.example.workbookapp.model.ScoreModel

class ScoresActivity : AppCompatActivity() {

    var dbHandler : DatabaseHelper = DatabaseHelper(this)
    var scoreList : List<ScoreModel> = ArrayList<ScoreModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        val layout = findViewById<LinearLayout>(R.id.linearLayoutScoreList)
        dbHandler = DatabaseHelper(this)
        fetchList()

        var currentQuestionIndex = 0

        for (score in scoreList) {

            val textScore = TextView(this).apply {
                text = score.quiz_name + " / " + score.score + " / " + score.dateTaken
            }

            layout.addView(textScore.apply { R.style.TextViewStyle })


        }
    }


    override fun onResume() {
        super.onResume()
        fetchList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchList(){
        scoreList = dbHandler!!.getALlScoreList()
    }
}