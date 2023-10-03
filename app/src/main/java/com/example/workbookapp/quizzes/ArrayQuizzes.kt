package com.example.workbookapp.quizzes

import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.workbookapp.MainActivity
import com.example.workbookapp.model.QuizListModel

class ArrayQuizzes {
//    val quizList = arrayOf("Id", "quiz_model", "quiz_name", "topic_name",
//                            "id1", "quiz_model1", "quiz_name1", "topic_name1")
//
//    val quizListTWo = arrayOf("Id", "quiz_model", "quiz_name", "topic_name",
//        "id1", "quiz_model1", "quiz_name1", "topic_name1")
//
//
//    //val even: Array = arrayOf("Id", "quiz_model", "quiz_name", "topic_name")
//    //val odd: Array = arr(1, 3, 5)
//
//    val lala: Array<QuizListModel> = QuizListModel(quizList, quizListTWo, quizList, quizListTWo)
//
//    val quizModelChoice2 = arrayOf("Id", "quiz_model", "quiz_name", "topic_name")




    //Log.e("Choice A", uri.toString())
    // Now you can use the path to import the database
//            val direct = File(Environment.getExternalStorageDirectory().toString() + "/English Workbook")
//            val success = dbHandler!!.exportDatabase(direct.toString())
//            if (success){
//                Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
//                Log.e("ExportDB:", "Successfully")
//            }else{
//                Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
//                Log.e("ExportDB:", "Failed")
//            }





    //
//                val direct = File(Environment.getExternalStorageDirectory().toString() + "/English Workbook")
//                Log.e("Location:", direct.toString())
//                if (!direct.exists()) {
//                    Log.e("ExportDB:", "True")
//
//
//                    val direct = File(Environment.getExternalStorageDirectory().toString() + "/English Workbook")
//                    val success = dbHandler!!.exportDatabase(direct.toString())
//                    if (success){
//                        Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
//                        Log.e("ExportDB:", "Successfully")
//                    }else{
//                        Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
//                        Log.e("ExportDB:", "Failed")
//                    }
//
////                    val success = dbHandler!!.exportDatabase(direct.toString())
////                    if (success){
////                        Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
////                        Log.e("ExportDB:", "Successfully")
////                    }else{
////                        Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
////                        Log.e("ExportDB:", "Failed")
////                    }
//                }else{
//                    Log.e("ExportDB:", "False")
//                    val success = dbHandler!!.exportDatabase(direct.toString())
//                    if (success){
//                        Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
//                        Log.e("ExportDB:", "Successfully")
//                    }else{
//                        Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
//                        Log.e("ExportDB:", "Failed")
//                    }
//                }
//            } else {
//                // Permissions denied.
//                Log.e("ExportDB:", "Permissions denied")




//        if (shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) ||
//            shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//            // Show an explanation to the user. This could be a dialog or a toast.
//            // After showing the explanation, request the permissions.
//            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_PERMISSIONS_CODE)
//        } else {
//            // No explanation needed; request the permissions.
//            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_PERMISSIONS_CODE)
//        }













//
//
//
//    private fun requestPermissions() {
//
////        if (shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) ||
////            shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
////            // Show an explanation to the user. This could be a dialog or a toast.
////            // After showing the explanation, request the permissions.
////            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_PERMISSIONS_CODE)
////        } else {
////            // No explanation needed; request the permissions.
////            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_PERMISSIONS_CODE)
////        }
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == MainActivity.REQUEST_PERMISSIONS_CODE) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Log.e("ExportDb:", "Access Granted")
////
////                val direct = File(Environment.getExternalStorageDirectory().toString() + "/English Workbook")
////                Log.e("Location:", direct.toString())
////                if (!direct.exists()) {
////                    Log.e("ExportDB:", "True")
////
////
////                    val direct = File(Environment.getExternalStorageDirectory().toString() + "/English Workbook")
////                    val success = dbHandler!!.exportDatabase(direct.toString())
////                    if (success){
////                        Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
////                        Log.e("ExportDB:", "Successfully")
////                    }else{
////                        Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
////                        Log.e("ExportDB:", "Failed")
////                    }
////
//////                    val success = dbHandler!!.exportDatabase(direct.toString())
//////                    if (success){
//////                        Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
//////                        Log.e("ExportDB:", "Successfully")
//////                    }else{
//////                        Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
//////                        Log.e("ExportDB:", "Failed")
//////                    }
////                }else{
////                    Log.e("ExportDB:", "False")
////                    val success = dbHandler!!.exportDatabase(direct.toString())
////                    if (success){
////                        Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
////                        Log.e("ExportDB:", "Successfully")
////                    }else{
////                        Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
////                        Log.e("ExportDB:", "Failed")
////                    }
////                }
////            } else {
////                // Permissions denied.
////                Log.e("ExportDB:", "Permissions denied")
//            }
//            else{
//                Log.e("ExportDb:", "Access Denied")
//            }
//        }
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == MainActivity.PICKFILE_RESULT_CODE && resultCode == ComponentActivity.RESULT_OK) {
//            val uri = data?.data
//            //Log.e("Choice A", uri.toString())
//            // Now you can use the path to import the database
//            val success = dbHandler!!.importDatabase(uri.toString())
//            if (success) {
//                Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT)
//                    .show()
//                Log.e("ImportDB:", "Successfully")
//            } else {
//                Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
//                Log.e("ImportDB:", "Failed")
//            }
//        }
//        else if (requestCode == MainActivity.PICKFOLDER_RESULT_CODE && resultCode == ComponentActivity.RESULT_OK) {
//            val uri = data?.data
//            //Log.e("Choice A", uri.toString())
//            // Now you can use the path to import the database
////            val direct = File(Environment.getExternalStorageDirectory().toString() + "/English Workbook")
////            val success = dbHandler!!.exportDatabase(direct.toString())
////            if (success){
////                Toast.makeText(this, "Database has been added successfully.", Toast.LENGTH_SHORT).show()
////                Log.e("ExportDB:", "Successfully")
////            }else{
////                Toast.makeText(this, "Database saving failed!!", Toast.LENGTH_SHORT).show()
////                Log.e("ExportDB:", "Failed")
////            }
//        }







}