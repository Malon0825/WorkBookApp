package com.example.workbookapp.history

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.example.workbookapp.R
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.model.ScoreModel

class HistoryActivity : AppCompatActivity() {

    var dbHandler : DatabaseHelper = DatabaseHelper(this)
    var scoreList : List<ScoreModel> = ArrayList<ScoreModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val layout = findViewById<LinearLayout>(R.id.linearLayoutScoreList)
        dbHandler = DatabaseHelper(this)
        fetchList()

        for (score in scoreList) {
            val textScore = TextView(this).apply {
                text = score.quiz_name + "  ||  " + score.dateTaken
                setTextAppearance(this@HistoryActivity, R.style.TextViewStyle) // Replace 'YourActivity' with the name of your activity
            }
            layout.addView(textScore)
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