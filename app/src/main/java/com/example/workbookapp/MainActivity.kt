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
            operationCopyPaste = dbHandler!!.importFromFirestoreToSQLite()
            if (operationCopyPaste == true){
                Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Failed to import data!!", Toast.LENGTH_LONG).show()
            }
        }

    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == REQUEST_PERMISSIONS_CODE) {
//
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                Log.e("ExportDb:", "Access Granted")
//
//                val documentsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
//                val direct = File(documentsDirectory, "English Workbook")
//
//                if (!direct.exists()) {
//                    direct.mkdirs()
//
//                }
//                val success = dbHandler!!.exportDatabase(direct.toString())
//                if (success) {
//                    Toast.makeText(
//                        this,
//                        "Database has been added successfully.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    Log.e("ExportDB:", "Successfully")
//                } else {
//                    Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
//                    Log.e("ExportDB:", "Failed")
//                }
//
//
//            }
//            else{
//                Log.e("ExportDb:", "Access Denied")
//            }
//        }else if (requestCode == NEW_REQUEST_PERMISSIONS_CODE){
//
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Log.e("ImportDb:", "Access Granted")
//
//                val documentsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
//                val direct = File(documentsDirectory, "English Workbook")
//                Log.e("ExportDB:", direct.toString())
//                if (!direct.exists()) {
//                    direct.mkdirs()
//                    Log.e("ExportDB:", "Direct is created")
//                }else{
//                    Log.e("ExportDB:", "Direct exist")
//                }
//
//                val success = dbHandler!!.importDatabase(direct.toString())
//                if (success){
//                    Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
//                    Log.e("ExportDB:", "Successfully")
//                }else{
//                    Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
//                    Log.e("ExportDB:", "Failed")
//                }
//            }
//        }
//        else{
//            Log.e("ExportDb:", "Access Denied")
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == PICKFILE_RESULT_CODE && resultCode == RESULT_OK) {
//            val folderUri = data?.data
//
//            // Use the folderUri to access the folder and store the file in it.
////            val documentsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
////            val direct = File(documentsDirectory, "English Workbook")
////
////            if (!direct.exists()) {
////                direct.mkdirs()
////            }
////
////            val success = dbHandler!!.importDatabase(folderUri)
////            if (success){
////                Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
////                Log.e("ExportDB:", "Successfully")
////            }else{
////                Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
////                Log.e("ExportDB:", "Failed")
////            }
//        }
//    }
//
////    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
////        super.onActivityResult(requestCode, resultCode, data)
////        if (requestCode == PICKFILE_RESULT_CODE && resultCode == RESULT_OK) {
////            val uri = data?.data
////            //Log.e("Choice A", uri.toString())
////            // Now you can use the path to import the database
////            val success = dbHandler!!.importDatabase(uri.toString())
////            if (success) {
////                Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT)
////                    .show()
////                Log.e("ImportDB:", "Successfully")
////            } else {
////                Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
////                Log.e("ImportDB:", "Failed")
////            }
////        }
////       else if (requestCode == PICKFOLDER_RESULT_CODE && resultCode == RESULT_OK) {
////            val uri = data?.data
////
////        }
////    }
    override fun onBackPressed() {
        val intent = Intent(this, LandingActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}