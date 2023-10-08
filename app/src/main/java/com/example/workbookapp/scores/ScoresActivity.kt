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

        for (score in scoreList) {
            val textQuizName = TextView(this).apply {
                text = score.quiz_name
                setTextAppearance(this@ScoresActivity, R.style.TextViewStyleHistoryScoreTitle)
            }
            val textDateTaken = TextView(this).apply {
                text = "  ||  " + score.score
                setTextAppearance(this@ScoresActivity, R.style.TextViewStyleHistoryScore)
            }

            // Create a new LinearLayout, add both TextViews to it, then add it to your main layout
            val layoutScore = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                addView(textQuizName)
                addView(textDateTaken)
            }
            layout.addView(layoutScore)
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