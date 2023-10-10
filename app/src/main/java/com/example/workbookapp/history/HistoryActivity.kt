package com.example.workbookapp.history

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.ui.graphics.Color
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
            val textQuizName = TextView(this).apply {
                text = score.quiz_name
                setTextAppearance(this@HistoryActivity, R.style.TextViewStyleHistoryScoreTitle)

                // Convert 100dp to pixels
                val maxWidthInPixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150f, resources.displayMetrics).toInt()

                // Set the maximum width of the TextView
                maxWidth = maxWidthInPixels
            }
            val textDateTaken = TextView(this).apply {
                text = "  ||  " + score.dateTaken
                setTextAppearance(this@HistoryActivity, R.style.TextViewStyleHistoryScore)
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