package com.example.workbookapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.workbookapp.database.DatabaseHelper
import com.example.workbookapp.quizzes.QuizTypeActivity

class AdminActivity : AppCompatActivity() {
    companion object {
        private var operationCopyPaste : Boolean? = null
    }
    var dbHandler : DatabaseHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val quizAdd= findViewById<Button>(R.id.buttonAddQuiz)
        quizAdd.setOnClickListener {
            val intent = Intent(this, QuizTypeActivity::class.java)
            startActivity(intent)

        }

        val exportData= findViewById<Button>(R.id.buttonExportDatabase)
        exportData.setOnClickListener {

            operationCopyPaste = dbHandler!!.exportDbToFirestore()
            if (operationCopyPaste == true){
                Toast.makeText(this, "Export complete.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Failed to export data!!", Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onBackPressed() {
        val intent = Intent(this, LandingActivity::class.java)
        startActivity(intent)
        finish()
    }


}