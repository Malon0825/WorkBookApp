package com.example.workbookapp

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.history.HistoryActivity
import com.example.workbookapp.lessons.LessonActivity
import com.example.workbookapp.quizzes.QuizzesActivity
import com.example.workbookapp.scores.ScoresActivity
import java.io.File
import java.util.jar.Manifest


class MainActivity : ComponentActivity() {
    companion object {
        const val PICKFILE_RESULT_CODE = 1
        const val PICKFOLDER_RESULT_CODE = 2
        private val REQUEST_PERMISSIONS_CODE = 123
        private val NEW_REQUEST_PERMISSIONS_CODE = 1234
        private var operationCopyPaste : Boolean? = null
    }
    var dbHandler : DatabaseHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lessons = findViewById<ImageButton>(R.id.imageButtonLessons)
        lessons.setOnClickListener {
            val intent = Intent(this, LessonActivity::class.java)
            startActivity(intent)
        }

        val quizzes = findViewById<ImageButton>(R.id.imageButtonQuizzes)
        quizzes.setOnClickListener {
            val intent = Intent(this, QuizzesActivity::class.java)
            startActivity(intent)
        }

        val scores = findViewById<ImageButton>(R.id.imageButtonScores)
        scores.setOnClickListener {
            val intent = Intent(this, ScoresActivity::class.java)
            startActivity(intent)
        }

        val historyButton = findViewById<ImageButton>(R.id.imageButtonHistory)
        historyButton.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        val importDb = findViewById<ImageButton>(R.id.imageButtonUpdate)
        importDb.setOnClickListener {

            try{
                val isQuizDeleted = dbHandler.deleteQuiz()
                val isQuizImported = dbHandler.importFromFirestoreToSQLite()

                if (isQuizDeleted && isQuizImported){
                    Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Update failed! Please check you internet connection and try again.", Toast.LENGTH_LONG).show()
                }
            }catch(e: Exception){
                Toast.makeText(this, "Failed to update quizzes: $e", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onBackPressed() {
        val intent = Intent(this, LandingActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}