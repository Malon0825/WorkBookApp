package com.example.workbookapp.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
import android.os.FileUtils
import android.util.Log
import com.example.workbookapp.model.AnswersModel
import com.example.workbookapp.model.QuizListModel
import com.example.workbookapp.model.QuizzesModel
import com.example.workbookapp.model.QuizzesMulChoice2Model
import com.example.workbookapp.model.QuizzesMulChoice6Model
import com.example.workbookapp.model.QuizzesMulChoice7Model
import com.example.workbookapp.model.QuizzesRearangeModel
import com.example.workbookapp.model.ScoreModel
import com.example.workbookapp.quizzes.QuizAddMulChoice2
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    val dbFirestore = Firebase.firestore

    companion object{
        private val DB_NAME = "EnglishWorkbook"
        private val DB_VERSION = 1

        const val DB_FILEPATH = "/data/data/com.example.workbookapp/databases/EnglishWorkbook"

        //Global
        private val INSTRUCTUON = "Instruction"

        //Quizzes table
        private val TABLE_NAME_QUIZ_LIST = "TABLE_NAME_QUIZ_LIST"
        private val QUIZ_LIST_ID = "QUIZ_LIST_ID"
        private val QUIZ_LIST_QUIZ_MODEL = "QUIZ_LIST_QUIZ_MODEL"
        private val QUIZ_LIST_QUIZ_NAME = "QUIZ_LIST_QUIZ_NAME"
        private val QUIZ_LIST_TOPIC_NAME = "QUIZ_LIST_TOPIC_NAME"

        //Quiz multiple choice 4
        private val TABLE_NAME_SYNTAX_ONE = "TABLE_NAME_SYNTAX_ONE"
        private val ID = "Id"
        private val TOPIC_NAME = "TopicName"
        private val QUIZ_NAME = "QuizName"
        private val QUESTION = "Questions"
        private val CHOICE_A = "ChoiceA"
        private val CHOICE_B = "ChoiceB"
        private val CHOICE_C = "ChoiceC"
        private val CHOICE_D = "ChoiceD"
        private val ANSWER = "Answer"

        //Quiz multiple choice 2
        private val TABLE_NAME_QUIZ_MUL_CHOICE_2 = "TABLE_NAME_QUIZ_MUL_CHOICE_2"
        private val ID_QUIZ_MUL_CHOICE_2 = "Id"
        private val TOPIC_NAME__QUIZ_MUL_CHOICE_2 = "TopicName"
        private val QUIZ_NAME__QUIZ_MUL_CHOICE_2 = "QuizName"
        private val QUESTION__QUIZ_MUL_CHOICE_2 = "Questions"
        private val CHOICE_A__QUIZ_MUL_CHOICE_2 = "ChoiceA"
        private val CHOICE_B__QUIZ_MUL_CHOICE_2 = "ChoiceB"
        private val ANSWER__QUIZ_MUL_CHOICE_2 = "Answer"

        //Quiz multiple choice 6
        private val TABLE_NAME_QUIZ_MUL_CHOICE_6 = "TABLE_NAME_QUIZ_MUL_CHOICE_6"
        private val ID_QUIZ_MUL_CHOICE_6 = "Id"
        private val TOPIC_NAME__QUIZ_MUL_CHOICE_6 = "TopicName"
        private val QUIZ_NAME__QUIZ_MUL_CHOICE_6 = "QuizName"
        private val QUESTION__QUIZ_MUL_CHOICE_6 = "Questions"
        private val CHOICE_A__QUIZ_MUL_CHOICE_6 = "ChoiceA"
        private val CHOICE_B__QUIZ_MUL_CHOICE_6 = "ChoiceB"
        private val CHOICE_C__QUIZ_MUL_CHOICE_6 = "ChoiceC"
        private val CHOICE_D__QUIZ_MUL_CHOICE_6 = "ChoiceD"
        private val CHOICE_E__QUIZ_MUL_CHOICE_6 = "ChoiceE"
        private val CHOICE_F__QUIZ_MUL_CHOICE_6 = "ChoiceF"
        private val ANSWER__QUIZ_MUL_CHOICE_6 = "Answer"

        //Quiz multiple choice 7
        private val TABLE_NAME_QUIZ_MUL_CHOICE_7 = "TABLE_NAME_QUIZ_MUL_CHOICE_7"
        private val ID_QUIZ_MUL_CHOICE_7 = "Id"
        private val TOPIC_NAME__QUIZ_MUL_CHOICE_7 = "TopicName"
        private val QUIZ_NAME__QUIZ_MUL_CHOICE_7 = "QuizName"
        private val QUESTION__QUIZ_MUL_CHOICE_7 = "Questions"
        private val CHOICE_A__QUIZ_MUL_CHOICE_7 = "ChoiceA"
        private val CHOICE_B__QUIZ_MUL_CHOICE_7 = "ChoiceB"
        private val CHOICE_C__QUIZ_MUL_CHOICE_7 = "ChoiceC"
        private val CHOICE_D__QUIZ_MUL_CHOICE_7 = "ChoiceD"
        private val CHOICE_E__QUIZ_MUL_CHOICE_7 = "ChoiceE"
        private val CHOICE_F__QUIZ_MUL_CHOICE_7 = "ChoiceF"
        private val CHOICE_G__QUIZ_MUL_CHOICE_7 = "ChoiceG"
        private val ANSWER__QUIZ_MUL_CHOICE_7 = "Answer"

        //Quiz rearrange
        private val TABLE_NAME_QUIZ_REARRANGE = "TABLE_NAME_QUIZ_REARRANGE"
        private val ID_QUIZ_QUIZ_REARRANGE = "Id"
        private val TOPIC_NAME_QUIZ_REARRANGE = "TopicName"
        private val QUIZ_NAME_QUIZ_REARRANGE = "QuizName"
        private val STATEMENT_ONE_QUIZ_REARRANGE = "StatementOne"
        private val STATEMENT_TWO_QUIZ_REARRANGE = "StatementTwo"
        private val STATEMENT_THREE_QUIZ_REARRANGE = "StatementThree"
        private val STATEMENT_CORRECT_QUIZ_REARRANGE = "StatementCorrect"


        //Answers table

        //Answer multiple choice
        private val ANSWERS_TABLE_NAME_SYNTAX_ONE = "ANSWERS_TABLE_NAME_SYNTAX_ONE"
        private val ANSWER_ID = "Id"
        private val ANSWER_QUIZ_NAME = "QuizName"
        private val ANSWER_QUESTION = "Questions"
        private val ANSWER_ANSWER = "Answer"


        //Scores

        //Scores table
        private val TABLE_NAME_SCORES = "TABLE_NAME_SCORES"
        private val SCORE_ID = "Id"
        private val SCORE_QUIZ_NAME = "QuizName"
        private val SCORE = "Score"
        private val DATE_TAKEN = "DateTaken"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_QUIZ_TABLE_NAME_QUIZ_LIST = "CREATE TABLE $TABLE_NAME_QUIZ_LIST ($QUIZ_LIST_ID INTEGER PRIMARY KEY, $QUIZ_LIST_QUIZ_MODEL TEXT, $QUIZ_LIST_QUIZ_NAME TEXT, $QUIZ_LIST_TOPIC_NAME TEXT)"
        p0?.execSQL(CREATE_QUIZ_TABLE_NAME_QUIZ_LIST)

        val CREATE_QUIZ_MULTIPLE_CHOICE_TABLE = "CREATE TABLE $TABLE_NAME_SYNTAX_ONE ($ID INTEGER PRIMARY KEY, $TOPIC_NAME TEXT, $INSTRUCTUON TEXT, $QUIZ_NAME TEXT, $QUESTION TEXT, $CHOICE_A TEXT, $CHOICE_B TEXT, $CHOICE_C TEXT, $CHOICE_D TEXT, $ANSWER TEXT)"
        p0?.execSQL(CREATE_QUIZ_MULTIPLE_CHOICE_TABLE)

        val CREATE_QUIZ_MULTIPLE_CHOICE_2_TABLE = "CREATE TABLE $TABLE_NAME_QUIZ_MUL_CHOICE_2 ($ID_QUIZ_MUL_CHOICE_2 INTEGER PRIMARY KEY, $INSTRUCTUON TEXT, $TOPIC_NAME__QUIZ_MUL_CHOICE_2 TEXT, $QUIZ_NAME__QUIZ_MUL_CHOICE_2 TEXT, $QUESTION__QUIZ_MUL_CHOICE_2 TEXT, $CHOICE_A__QUIZ_MUL_CHOICE_2 TEXT, $CHOICE_B__QUIZ_MUL_CHOICE_2 TEXT, $ANSWER__QUIZ_MUL_CHOICE_2 TEXT)"
        p0?.execSQL(CREATE_QUIZ_MULTIPLE_CHOICE_2_TABLE)

        val CREATE_QUIZ_MULTIPLE_CHOICE_6_TABLE = "CREATE TABLE $TABLE_NAME_QUIZ_MUL_CHOICE_6 ($ID_QUIZ_MUL_CHOICE_6 INTEGER PRIMARY KEY, $INSTRUCTUON TEXT, $TOPIC_NAME__QUIZ_MUL_CHOICE_6 TEXT, $QUIZ_NAME__QUIZ_MUL_CHOICE_6 TEXT, $QUESTION__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_A__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_B__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_C__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_D__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_E__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_F__QUIZ_MUL_CHOICE_6 TEXT, $ANSWER__QUIZ_MUL_CHOICE_6 TEXT)"
        p0?.execSQL(CREATE_QUIZ_MULTIPLE_CHOICE_6_TABLE)

        val CREATE_QUIZ_MULTIPLE_CHOICE_7_TABLE = "CREATE TABLE $TABLE_NAME_QUIZ_MUL_CHOICE_7 ($ID_QUIZ_MUL_CHOICE_7 INTEGER PRIMARY KEY, $INSTRUCTUON TEXT, $TOPIC_NAME__QUIZ_MUL_CHOICE_7 TEXT, $QUIZ_NAME__QUIZ_MUL_CHOICE_7 TEXT, $QUESTION__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_A__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_B__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_C__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_D__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_E__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_F__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_G__QUIZ_MUL_CHOICE_7 TEXT, $ANSWER__QUIZ_MUL_CHOICE_7 TEXT)"
        p0?.execSQL(CREATE_QUIZ_MULTIPLE_CHOICE_7_TABLE)

        val CREATE_QUIZ_REARRANGE = "CREATE TABLE $TABLE_NAME_QUIZ_REARRANGE ($ID_QUIZ_QUIZ_REARRANGE INTEGER PRIMARY KEY, $INSTRUCTUON TEXT, $TOPIC_NAME_QUIZ_REARRANGE TEXT, $QUIZ_NAME_QUIZ_REARRANGE TEXT, $STATEMENT_ONE_QUIZ_REARRANGE TEXT, $STATEMENT_TWO_QUIZ_REARRANGE TEXT, $STATEMENT_THREE_QUIZ_REARRANGE TEXT, $STATEMENT_CORRECT_QUIZ_REARRANGE TEXT)"
        p0?.execSQL(CREATE_QUIZ_REARRANGE)

        val CREATE_ANSWER_MULTIPLE_CHOICE_TABLE = "CREATE TABLE $ANSWERS_TABLE_NAME_SYNTAX_ONE ($ANSWER_ID INTEGER PRIMARY KEY, $QUIZ_NAME TEXT, $QUESTION TEXT, $CHOICE_A TEXT, $CHOICE_B TEXT, $CHOICE_C TEXT, $CHOICE_D TEXT, $ANSWER TEXT)"
        p0?.execSQL(CREATE_ANSWER_MULTIPLE_CHOICE_TABLE)

        val CREATE_SCORES_TABLE = "CREATE TABLE $TABLE_NAME_SCORES ($SCORE_ID INTEGER PRIMARY KEY, $SCORE_QUIZ_NAME TEXT, $SCORE TEXT, $DATE_TAKEN TEXT)"
        p0?.execSQL(CREATE_SCORES_TABLE)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val DROP_TABLE_TABLE_NAME_QUIZ_LIST = "DROP TABLE IF EXISTS $TABLE_NAME_QUIZ_LIST"
        p0?.execSQL(DROP_TABLE_TABLE_NAME_QUIZ_LIST)
        onCreate(p0)

        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME_SYNTAX_ONE"
        p0?.execSQL(DROP_TABLE)
        onCreate(p0)

        val DROP_TABLE_MULTIPLE_2 = "DROP TABLE IF EXISTS $TABLE_NAME_QUIZ_MUL_CHOICE_2"
        p0?.execSQL(DROP_TABLE_MULTIPLE_2)
        onCreate(p0)

        val DROP_TABLE_MULTIPLE_6 = "DROP TABLE IF EXISTS $TABLE_NAME_QUIZ_MUL_CHOICE_6"
        p0?.execSQL(DROP_TABLE_MULTIPLE_6)
        onCreate(p0)

        val DROP_TABLE_MULTIPLE_7 = "DROP TABLE IF EXISTS $TABLE_NAME_QUIZ_MUL_CHOICE_7"
        p0?.execSQL(DROP_TABLE_MULTIPLE_7)
        onCreate(p0)

        val DROP_TABLE_ANSWER = "DROP TABLE IF EXISTS $ANSWERS_TABLE_NAME_SYNTAX_ONE"
        p0?.execSQL(DROP_TABLE_ANSWER)
        onCreate(p0)

        val DROP_TABLE_SCORE = "DROP TABLE IF EXISTS $TABLE_NAME_SCORES"
        p0?.execSQL(DROP_TABLE_SCORE)
        onCreate(p0)
    }


    @Throws(IOException::class)
    fun copyFile(sourceFile: File, destFile: File) {
        FileInputStream(sourceFile).use { input ->
            FileOutputStream(destFile).use { output ->
                input.channel.transferTo(0, input.channel.size(), output.channel)
            }
        }
    }

    @Throws(IOException::class)
    fun exportDatabase(dbPath: String): Boolean {
        close()
        val newDb = File(dbPath)
        val oldDb = File(DB_FILEPATH)
        if (newDb.exists()) {
            // Change the destination path to the path of the destination file.
            copyFile(oldDb, File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "EnglishWorkbook"))
            writableDatabase.close()
            return true
        }
        return false
    }

    @Throws(IOException::class)
    fun importDatabase(dbPath: String): Boolean {
        close()
        val newDb = File(dbPath)
        val oldDb = File(DB_FILEPATH)
        // Check if the new database file exists.
        if (newDb.exists()) {
            Log.e("Import:", "Entered")
            try {
                // Delete the old database file.
                oldDb.delete()
                // Copy the new database file to the db file path.
               // copyFile(File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "EnglishWorkbook"), oldDb)
                copyFile(oldDb, File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "EnglishWorkbook"))
                Log.e("ImportDatabaseHelper:", "Success")
            } catch (e: IllegalArgumentException){
                Log.e("ImportDatabaseHelper:", e.message.toString())
            }finally {
                writableDatabase.close()
            }

//            // Open the database at the db file path.
//            val database = openDatabase(DB_FILEPATH)
//
//            // Close the database.
//            database.close()

            return true
        }

        return false
    }
//    @Throws(IOException::class)
//    fun importDatabase(dbPath: String): Boolean {
//        close()
//        val newDb = File(dbPath)
//        val oldDb = File(DB_FILEPATH)
//        if (newDb.exists()) {
//            copyFile(newDb, oldDb)
//            writableDatabase.close()
//            return true
//        }
//        return false
//    }
//
//    @Throws(IOException::class)
//    fun exportDatabase(dbPath: String): Boolean {
//        close()
//        val newDb = File(DB_FILEPATH)
//        val oldDb = File(dbPath)
//        if (newDb.exists()) {
//            copyFile(newDb, oldDb)
//            writableDatabase.close()
//            return true
//        }
//        return false
//    }


    fun getALlQuizList(topic: String): List<QuizListModel>{
        val quiz_list = ArrayList<QuizListModel>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME_QUIZ_LIST WHERE $QUIZ_LIST_TOPIC_NAME = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(topic))
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val quiz = QuizListModel()
                try {
                    quiz.id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_LIST_ID)))
                    quiz.quiz_name = cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_LIST_QUIZ_NAME))
                    quiz.quiz_model = cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_LIST_QUIZ_MODEL))
                    quiz.topic_name = cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_LIST_TOPIC_NAME))
                    quiz_list.add(quiz)
                } catch (e: IllegalArgumentException) {
                    Log.e("DBHelper", e.message.toString())
                }
            }
        }
        cursor.close()
        return quiz_list
    }

    //Fix the date_take data is null, score_id is also null
    fun getALlScoreList(): List<ScoreModel>{
        val score_list = ArrayList<ScoreModel>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME_SCORES"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val score = ScoreModel()
                try {
                    score.score_id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(SCORE_ID)))
                    score.quiz_name = cursor.getString(cursor.getColumnIndexOrThrow(SCORE_QUIZ_NAME))
                    score.score = cursor.getString(cursor.getColumnIndexOrThrow(SCORE))
                    score.dateTaken = cursor.getString(cursor.getColumnIndexOrThrow(DATE_TAKEN))
                    score_list.add(score)
                    Log.e("Score Data", score.quiz_name)
                } catch (e: IllegalArgumentException) {
                    Log.e("DBHelper", e.message.toString())
                }
            }
        }
        cursor.close()
        return score_list
    }

    //Multiple choice (4)
    fun getALlQuiz(quiz_name: String, topic: String): List<QuizzesModel>{
        val quiz_list = ArrayList<QuizzesModel>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME_SYNTAX_ONE WHERE $TOPIC_NAME = ? AND $QUIZ_NAME = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(topic, quiz_name))
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val quiz = QuizzesModel()
                try {
                    quiz.id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(ID)))
                    quiz.quiz_name = cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_NAME))
                    quiz.instruction = cursor.getString(cursor.getColumnIndexOrThrow(INSTRUCTUON))
                    quiz.question = cursor.getString(cursor.getColumnIndexOrThrow(QUESTION))
                    quiz.choice_a = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_A))
                    quiz.choice_b = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_B))
                    quiz.choice_c = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_C))
                    quiz.choice_d = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_D))
                    quiz.answer = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER))
                    Log.e("Choice A", quiz.choice_a)
                    quiz_list.add(quiz)
                } catch (e: IllegalArgumentException) {
                    Log.e("DBHelper", e.message.toString())
                }
            }
        }
        cursor.close()
        return quiz_list
    }

    //Multiple choice (2)
    fun getALlQuizModel2(quiz_name: String, topic: String): List<QuizzesMulChoice2Model>{
        val quiz_list = ArrayList<QuizzesMulChoice2Model>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME_QUIZ_MUL_CHOICE_2 WHERE $TOPIC_NAME__QUIZ_MUL_CHOICE_2 = ? AND $QUIZ_NAME__QUIZ_MUL_CHOICE_2 = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(topic, quiz_name))
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val quiz = QuizzesMulChoice2Model()
                try {
                    quiz.id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(ID_QUIZ_MUL_CHOICE_2)))
                    quiz.quiz_name = cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_NAME__QUIZ_MUL_CHOICE_2))
                    quiz.instruction = cursor.getString(cursor.getColumnIndexOrThrow(INSTRUCTUON))
                    quiz.question = cursor.getString(cursor.getColumnIndexOrThrow(QUESTION__QUIZ_MUL_CHOICE_2))
                    quiz.choice_a = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_A__QUIZ_MUL_CHOICE_2))
                    quiz.choice_b = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_B__QUIZ_MUL_CHOICE_2))
                    quiz.answer = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER__QUIZ_MUL_CHOICE_2))
                    quiz_list.add(quiz)
                } catch (e: IllegalArgumentException) {
                    Log.e("DBHelper", e.message.toString())
                }
            }
        }
        cursor.close()
        return quiz_list
    }

    //Multiple choice (6)
    fun getALlQuizModel6(quiz_name: String, topic: String): List<QuizzesMulChoice6Model>{
        val quiz_list = ArrayList<QuizzesMulChoice6Model>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME_QUIZ_MUL_CHOICE_6 WHERE $TOPIC_NAME__QUIZ_MUL_CHOICE_6 = ? AND $QUIZ_NAME__QUIZ_MUL_CHOICE_6 = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(topic, quiz_name))
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val quiz = QuizzesMulChoice6Model()
                try {
                    quiz.id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(ID_QUIZ_MUL_CHOICE_6)))
                    quiz.quiz_name = cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_NAME__QUIZ_MUL_CHOICE_6))
                    quiz.instruction = cursor.getString(cursor.getColumnIndexOrThrow(INSTRUCTUON))
                    quiz.question = cursor.getString(cursor.getColumnIndexOrThrow(QUESTION__QUIZ_MUL_CHOICE_6))
                    quiz.choice_a = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_A__QUIZ_MUL_CHOICE_6))
                    quiz.choice_b = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_B__QUIZ_MUL_CHOICE_6))
                    quiz.choice_c = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_C__QUIZ_MUL_CHOICE_6))
                    quiz.choice_d = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_D__QUIZ_MUL_CHOICE_6))
                    quiz.choice_e = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_E__QUIZ_MUL_CHOICE_6))
                    quiz.choice_f = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_F__QUIZ_MUL_CHOICE_6))
                    quiz.answer = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER__QUIZ_MUL_CHOICE_6))
                    quiz_list.add(quiz)
                } catch (e: IllegalArgumentException) {
                    Log.e("DBHelper", e.message.toString())
                }
            }
        }
        cursor.close()
        return quiz_list
    }

    //Multiple choice (7)
    fun getALlQuizModel7(quiz_name: String, topic: String): List<QuizzesMulChoice7Model>{
        val quiz_list = ArrayList<QuizzesMulChoice7Model>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME_QUIZ_MUL_CHOICE_7 WHERE $TOPIC_NAME__QUIZ_MUL_CHOICE_7 = ? AND $QUIZ_NAME__QUIZ_MUL_CHOICE_7 = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(topic, quiz_name))
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val quiz = QuizzesMulChoice7Model()
                try {
                    quiz.id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(ID_QUIZ_MUL_CHOICE_7)))
                    quiz.quiz_name = cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_NAME__QUIZ_MUL_CHOICE_7))
                    quiz.instruction = cursor.getString(cursor.getColumnIndexOrThrow(INSTRUCTUON))
                    quiz.question = cursor.getString(cursor.getColumnIndexOrThrow(QUESTION__QUIZ_MUL_CHOICE_7))
                    quiz.choice_a = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_A__QUIZ_MUL_CHOICE_7))
                    quiz.choice_b = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_B__QUIZ_MUL_CHOICE_7))
                    quiz.choice_c = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_C__QUIZ_MUL_CHOICE_7))
                    quiz.choice_d = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_D__QUIZ_MUL_CHOICE_7))
                    quiz.choice_e = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_E__QUIZ_MUL_CHOICE_7))
                    quiz.choice_f = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_F__QUIZ_MUL_CHOICE_7))
                    quiz.choice_g = cursor.getString(cursor.getColumnIndexOrThrow(CHOICE_G__QUIZ_MUL_CHOICE_7))
                    quiz.answer = cursor.getString(cursor.getColumnIndexOrThrow(ANSWER__QUIZ_MUL_CHOICE_7))
                    quiz_list.add(quiz)
                } catch (e: IllegalArgumentException) {
                    Log.e("DBHelper", e.message.toString())
                }
            }
        }
        cursor.close()
        return quiz_list
    }

    //Rearrange quiz
    fun getQuizRearrange(quiz_name: String, topic: String): List<QuizzesRearangeModel> {
        val quiz_list = ArrayList<QuizzesRearangeModel>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME_QUIZ_REARRANGE WHERE $TOPIC_NAME_QUIZ_REARRANGE = ? AND $QUIZ_NAME_QUIZ_REARRANGE = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(topic, quiz_name))
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val quiz = QuizzesRearangeModel()
                try {
                    quiz.id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(ID_QUIZ_QUIZ_REARRANGE)))
                    quiz.quiz_name = cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_NAME_QUIZ_REARRANGE))
                    quiz.quiz_topic = cursor.getString(cursor.getColumnIndexOrThrow(TOPIC_NAME_QUIZ_REARRANGE))
                    quiz.instruction = cursor.getString(cursor.getColumnIndexOrThrow(INSTRUCTUON))
                    quiz.quiz_statement_one = cursor.getString(cursor.getColumnIndexOrThrow(STATEMENT_ONE_QUIZ_REARRANGE))
                    quiz.quiz_statement_two = cursor.getString(cursor.getColumnIndexOrThrow(STATEMENT_TWO_QUIZ_REARRANGE))
                    quiz.quiz_statement_three = cursor.getString(cursor.getColumnIndexOrThrow(STATEMENT_THREE_QUIZ_REARRANGE))
                    quiz.quiz_statement_correct = cursor.getString(cursor.getColumnIndexOrThrow(STATEMENT_CORRECT_QUIZ_REARRANGE))
                    quiz_list.add(quiz)
                } catch (e: IllegalArgumentException) {
                    Log.e("DBHelper", e.message.toString())
                }
            }
        }
        cursor.close()
        return quiz_list
    }


    //Adding quiz to identify the topic
    fun addALlQuizList(quiz : QuizListModel): Boolean{ val db = this.writableDatabase
        val values = ContentValues()
        values.put(QUIZ_LIST_TOPIC_NAME, quiz.topic_name)
        values.put(QUIZ_LIST_QUIZ_NAME, quiz.quiz_name)
        values.put(QUIZ_LIST_QUIZ_MODEL, quiz.quiz_model)

        var success : Boolean = false
        try
        {
            val is_success = db.insertOrThrow(TABLE_NAME_QUIZ_LIST, null, values)
            success = (is_success != 0L)
        } catch (e: Exception)
        {
            Log.e("DBHelper", e.message.toString())
        }
        finally {
            db.close()
            return success
        }
    }


    //Add quiz multiple choice (4)
    fun addQuiz(quiz : QuizzesModel): Boolean{ val db = this.writableDatabase
        val values = ContentValues()
        values.put(TOPIC_NAME, quiz.quiz_topic)
        values.put(QUIZ_NAME, quiz.quiz_name)
        values.put(QUESTION, quiz.question)
        values.put(INSTRUCTUON, quiz.instruction)
        values.put(CHOICE_A, quiz.choice_a)
        values.put(CHOICE_B, quiz.choice_b)
        values.put(CHOICE_C, quiz.choice_c)
        values.put(CHOICE_D, quiz.choice_d)
        values.put(ANSWER, quiz.answer)

        var success : Boolean = false
        try
        {
            val is_success = db.insertOrThrow(TABLE_NAME_SYNTAX_ONE, null, values)
            success = (is_success != 0L)
        } catch (e: Exception)
        {
            Log.e("DBHelper", e.message.toString())
        }
        finally {
            db.close()
            return success
        }
    }

    //Add quiz multiple choice (2)
    fun addQuizMulChoice2(quiz : QuizzesMulChoice2Model): Boolean{ val db = this.writableDatabase
        val values = ContentValues()

        values.put(TOPIC_NAME__QUIZ_MUL_CHOICE_2, quiz.quiz_topic)
        values.put(QUIZ_NAME__QUIZ_MUL_CHOICE_2, quiz.quiz_name)
        values.put(INSTRUCTUON, quiz.instruction)
        values.put(QUESTION__QUIZ_MUL_CHOICE_2, quiz.question)
        values.put(CHOICE_A__QUIZ_MUL_CHOICE_2, quiz.choice_a)
        values.put(CHOICE_B__QUIZ_MUL_CHOICE_2, quiz.choice_b)
        values.put(ANSWER__QUIZ_MUL_CHOICE_2, quiz.answer)

        var success : Boolean = false
        try
        {
            val is_success = db.insertOrThrow(TABLE_NAME_QUIZ_MUL_CHOICE_2, null, values)
            success = (is_success != 0L)
        } catch (e: Exception)
        {
            Log.e("DBHelper", e.message.toString())
        }
        finally {
            db.close()
            return success
        }
    }

    //Add quiz multiple choice (6)
    fun addQuizMulChoice6(quiz : QuizzesMulChoice6Model): Boolean{ val db = this.writableDatabase
        val values = ContentValues()

        values.put(TOPIC_NAME__QUIZ_MUL_CHOICE_6, quiz.quiz_topic)
        values.put(QUIZ_NAME__QUIZ_MUL_CHOICE_6, quiz.quiz_name)
        values.put(QUESTION__QUIZ_MUL_CHOICE_6, quiz.question)
        values.put(INSTRUCTUON, quiz.instruction)
        values.put(CHOICE_A__QUIZ_MUL_CHOICE_6, quiz.choice_a)
        values.put(CHOICE_B__QUIZ_MUL_CHOICE_6, quiz.choice_b)
        values.put(CHOICE_C__QUIZ_MUL_CHOICE_6, quiz.choice_c)
        values.put(CHOICE_D__QUIZ_MUL_CHOICE_6, quiz.choice_d)
        values.put(CHOICE_E__QUIZ_MUL_CHOICE_6, quiz.choice_e)
        values.put(CHOICE_F__QUIZ_MUL_CHOICE_6, quiz.choice_f)
        values.put(ANSWER__QUIZ_MUL_CHOICE_6, quiz.answer)

        var success : Boolean = false
        try
        {
            val is_success = db.insertOrThrow(TABLE_NAME_QUIZ_MUL_CHOICE_6, null, values)
            success = (is_success != 0L)
        } catch (e: Exception)
        {
            Log.e("DBHelper", e.message.toString())
        }
        finally {
            db.close()
            return success
        }
    }

    //Add quiz multiple choice (7)
    fun addQuizMulChoice7(quiz : QuizzesMulChoice7Model): Boolean{ val db = this.writableDatabase
        val values = ContentValues()

        values.put(TOPIC_NAME__QUIZ_MUL_CHOICE_7, quiz.quiz_topic)
        values.put(QUIZ_NAME__QUIZ_MUL_CHOICE_7, quiz.quiz_name)
        values.put(QUESTION__QUIZ_MUL_CHOICE_7, quiz.question)
        values.put(INSTRUCTUON, quiz.instruction)
        values.put(CHOICE_A__QUIZ_MUL_CHOICE_7, quiz.choice_a)
        values.put(CHOICE_B__QUIZ_MUL_CHOICE_7, quiz.choice_b)
        values.put(CHOICE_C__QUIZ_MUL_CHOICE_7, quiz.choice_c)
        values.put(CHOICE_D__QUIZ_MUL_CHOICE_7, quiz.choice_d)
        values.put(CHOICE_E__QUIZ_MUL_CHOICE_7, quiz.choice_e)
        values.put(CHOICE_F__QUIZ_MUL_CHOICE_7, quiz.choice_f)
        values.put(CHOICE_G__QUIZ_MUL_CHOICE_7, quiz.choice_g)
        values.put(ANSWER__QUIZ_MUL_CHOICE_7, quiz.answer)

        var success : Boolean = false
        try
        {
            val is_success = db.insertOrThrow(TABLE_NAME_QUIZ_MUL_CHOICE_7, null, values)
            success = (is_success != 0L)
        } catch (e: Exception)
        {
            Log.e("DBHelper", e.message.toString())
        }
        finally {
            db.close()
            return success
        }
    }

    //Add quiz rearrange
    fun addQuizRearrange(quiz : QuizzesRearangeModel): Boolean{ val db = this.writableDatabase
        val values = ContentValues()

        values.put(TOPIC_NAME_QUIZ_REARRANGE, quiz.quiz_topic)
        values.put(QUIZ_NAME_QUIZ_REARRANGE, quiz.quiz_name)
        values.put(INSTRUCTUON, quiz.instruction)
        values.put(STATEMENT_ONE_QUIZ_REARRANGE, quiz.quiz_statement_one)
        values.put(STATEMENT_TWO_QUIZ_REARRANGE, quiz.quiz_statement_two)
        values.put(STATEMENT_THREE_QUIZ_REARRANGE, quiz.quiz_statement_three)
        values.put(STATEMENT_CORRECT_QUIZ_REARRANGE, quiz.quiz_statement_correct)

        var success : Boolean = false
        try
        {
            val is_success = db.insertOrThrow(TABLE_NAME_QUIZ_REARRANGE, null, values)
            success = (is_success != 0L)
        } catch (e: Exception)
        {
            Log.e("DBHelper", e.message.toString())
        }
        finally {
            db.close()
            return success
        }
    }




    fun addAnswer(quiz : AnswersModel): Boolean{ val db = this.writableDatabase
        val values = ContentValues()
        values.put(ANSWER_QUIZ_NAME, quiz.quiz_name)
        values.put(ANSWER_QUESTION, quiz.question)
        values.put(ANSWER_ANSWER, quiz.answer_answer)

        var success : Boolean = false
        try
        {
            val is_success = db.insertOrThrow(ANSWERS_TABLE_NAME_SYNTAX_ONE, null, values)
            success = (is_success != 0L)
        } catch (e: Exception)
        {
            Log.e("DBHelper", e.message.toString())
        }
        finally {
            db.close()
            return success
        }
    }

    fun addScore(score : ScoreModel): Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(SCORE_QUIZ_NAME, score.quiz_name)
        values.put(SCORE, score.score)
        values.put(DATE_TAKEN, score.dateTaken)

        var success : Boolean = false
        try
        {
            val is_success = db.insertOrThrow(TABLE_NAME_SCORES, null, values)
            success = (is_success != 0L)
        } catch (e: Exception)
        {
            Log.e("DBHelper", e.message.toString())
        }
        finally {
            db.close()
            return success
        }
    }



    fun importFromFirestoreToSQLite() : Boolean{
        try {
            TABLE_NAME_QUIZ_LIST_IMPORT()
            TABLE_NAME_SYNTAX_ONE_IMPORT()
            TABLE_NAME_QUIZ_MUL_CHOICE_2_IMPORT()
            TABLE_NAME_QUIZ_MUL_CHOICE_6_IMPORT()
            TABLE_NAME_QUIZ_MUL_CHOICE_7_IMPORT()
            TABLE_NAME_QUIZ_REARRANGE_IMPORT()
        }catch (e: Exception){
            Log.e("DBHelper", e.message.toString())
            throw e
        }
        return true
    }

    fun TABLE_NAME_SYNTAX_ONE_IMPORT() {
        // Get a reference to the Firestore collection
        val collection = dbFirestore.collection("TABLE_NAME_SYNTAX_ONE")

        // Fetch all documents from the collection
        collection.get().addOnSuccessListener { documents ->
            for (document in documents) {
                val id = document.getLong(ID)
                val topicName = document.getString(TOPIC_NAME)
                val quizName = document.getString(QUIZ_NAME)
                val question = document.getString(QUESTION)
                val choiceA = document.getString(CHOICE_A)
                val choiceB = document.getString(CHOICE_B)
                val choiceC = document.getString(CHOICE_C)
                val choiceD = document.getString(CHOICE_D)
                val answer = document.getString(ANSWER)
                val instruction = document.getString(INSTRUCTUON)

                // Create a ContentValues object
                val values = ContentValues()
                values.put(ID, id)
                values.put(TOPIC_NAME, topicName)
                values.put(QUIZ_NAME, quizName)
                values.put(QUESTION, question)
                values.put(CHOICE_A, choiceA)
                values.put(CHOICE_B, choiceB)
                values.put(CHOICE_C, choiceC)
                values.put(CHOICE_D, choiceD)
                values.put(ANSWER, answer)
                values.put(INSTRUCTUON, instruction)

                // Insert the data into the SQLite database
                val db = this.writableDatabase
                db.insert(TABLE_NAME_SYNTAX_ONE, null, values)
            }
            Log.e("SQLite: ", "Import complete for TABLE_NAME_SYNTAX_ONE!!")
        }.addOnFailureListener { e ->
            Log.w("Error fetching documents", e)
        }
    }

    fun TABLE_NAME_QUIZ_MUL_CHOICE_2_IMPORT() {
        // Get a reference to the Firestore collection
        val collection = dbFirestore.collection("TABLE_NAME_QUIZ_MUL_CHOICE_2")

        // Fetch all documents from the collection
        collection.get().addOnSuccessListener { documents ->
            for (document in documents) {
                val id = document.getLong(ID_QUIZ_MUL_CHOICE_2)
                val topicName = document.getString(TOPIC_NAME__QUIZ_MUL_CHOICE_2)
                val quizName = document.getString(QUIZ_NAME__QUIZ_MUL_CHOICE_2)
                val question = document.getString(QUESTION__QUIZ_MUL_CHOICE_2)
                val choiceA = document.getString(CHOICE_A__QUIZ_MUL_CHOICE_2)
                val choiceB = document.getString(CHOICE_B__QUIZ_MUL_CHOICE_2)
                val answer = document.getString(ANSWER__QUIZ_MUL_CHOICE_2)
                val instruction = document.getString(INSTRUCTUON)

                // Create a ContentValues object
                val values = ContentValues()
                values.put(ID_QUIZ_MUL_CHOICE_2, id)
                values.put(TOPIC_NAME__QUIZ_MUL_CHOICE_2, topicName)
                values.put(QUIZ_NAME__QUIZ_MUL_CHOICE_2, quizName)
                values.put(QUESTION__QUIZ_MUL_CHOICE_2, question)
                values.put(CHOICE_A__QUIZ_MUL_CHOICE_2, choiceA)
                values.put(CHOICE_B__QUIZ_MUL_CHOICE_2, choiceB)
                values.put(ANSWER__QUIZ_MUL_CHOICE_2, answer)
                values.put(INSTRUCTUON, instruction)

                // Insert the data into the SQLite database
                val db = this.writableDatabase
                db.insert(TABLE_NAME_QUIZ_MUL_CHOICE_2, null, values)
            }
            Log.e("SQLite: ", "Import complete for TABLE_NAME_QUIZ_MUL_CHOICE_2!!")
        }.addOnFailureListener { e ->
            Log.w("Error fetching documents", e)
        }
    }

    fun TABLE_NAME_QUIZ_MUL_CHOICE_6_IMPORT() {
        // Get a reference to the Firestore collection
        val collection = dbFirestore.collection("TABLE_NAME_QUIZ_MUL_CHOICE_6")

        // Fetch all documents from the collection
        collection.get().addOnSuccessListener { documents ->
            for (document in documents) {
                val id = document.getLong(ID_QUIZ_MUL_CHOICE_6)
                val topicName = document.getString(TOPIC_NAME__QUIZ_MUL_CHOICE_6)
                val quizName = document.getString(QUIZ_NAME__QUIZ_MUL_CHOICE_6)
                val question = document.getString(QUESTION__QUIZ_MUL_CHOICE_6)
                val choiceA = document.getString(CHOICE_A__QUIZ_MUL_CHOICE_6)
                val choiceB = document.getString(CHOICE_B__QUIZ_MUL_CHOICE_6)
                val choiceC = document.getString(CHOICE_C__QUIZ_MUL_CHOICE_6)
                val choiceD = document.getString(CHOICE_D__QUIZ_MUL_CHOICE_6)
                val choiceE = document.getString(CHOICE_E__QUIZ_MUL_CHOICE_6)
                val choiceF = document.getString(CHOICE_F__QUIZ_MUL_CHOICE_6)
                val answer = document.getString(ANSWER__QUIZ_MUL_CHOICE_6)
                val instruction = document.getString(INSTRUCTUON)

                // Create a ContentValues object
                val values = ContentValues()
                values.put(ID_QUIZ_MUL_CHOICE_6, id)
                values.put(TOPIC_NAME__QUIZ_MUL_CHOICE_6, topicName)
                values.put(QUIZ_NAME__QUIZ_MUL_CHOICE_6, quizName)
                values.put(QUESTION__QUIZ_MUL_CHOICE_6, question)
                values.put(CHOICE_A__QUIZ_MUL_CHOICE_6, choiceA)
                values.put(CHOICE_B__QUIZ_MUL_CHOICE_6, choiceB)
                values.put(CHOICE_C__QUIZ_MUL_CHOICE_6, choiceC)
                values.put(CHOICE_D__QUIZ_MUL_CHOICE_6, choiceD)
                values.put(CHOICE_E__QUIZ_MUL_CHOICE_6, choiceE)
                values.put(CHOICE_F__QUIZ_MUL_CHOICE_6, choiceF)
                values.put(ANSWER__QUIZ_MUL_CHOICE_6, answer)
                values.put(INSTRUCTUON, instruction)

                // Insert the data into the SQLite database
                val db = this.writableDatabase
                db.insert(TABLE_NAME_QUIZ_MUL_CHOICE_6, null, values)
            }
            Log.e("SQLite: ", "Import complete for TABLE_NAME_QUIZ_MUL_CHOICE_6!!")
        }.addOnFailureListener { e ->
            Log.w("Error fetching documents", e)
        }
    }

    fun TABLE_NAME_QUIZ_MUL_CHOICE_7_IMPORT() {
        // Get a reference to the Firestore collection
        val collection = dbFirestore.collection("TABLE_NAME_QUIZ_MUL_CHOICE_7")

        // Fetch all documents from the collection
        collection.get().addOnSuccessListener { documents ->
            for (document in documents) {
                val id = document.getLong(ID_QUIZ_MUL_CHOICE_7)
                val topicName = document.getString(TOPIC_NAME__QUIZ_MUL_CHOICE_7)
                val quizName = document.getString(QUIZ_NAME__QUIZ_MUL_CHOICE_7)
                val question = document.getString(QUESTION__QUIZ_MUL_CHOICE_7)
                val choiceA = document.getString(CHOICE_A__QUIZ_MUL_CHOICE_7)
                val choiceB = document.getString(CHOICE_B__QUIZ_MUL_CHOICE_7)
                val choiceC = document.getString(CHOICE_C__QUIZ_MUL_CHOICE_7)
                val choiceD = document.getString(CHOICE_D__QUIZ_MUL_CHOICE_7)
                val choiceE = document.getString(CHOICE_E__QUIZ_MUL_CHOICE_7)
                val choiceF = document.getString(CHOICE_F__QUIZ_MUL_CHOICE_7)
                val choiceG = document.getString(CHOICE_G__QUIZ_MUL_CHOICE_7)
                val answer = document.getString(ANSWER__QUIZ_MUL_CHOICE_7)
                val instruction = document.getString(INSTRUCTUON)

                // Create a ContentValues object
                val values = ContentValues()
                values.put(ID_QUIZ_MUL_CHOICE_7, id)
                values.put(TOPIC_NAME__QUIZ_MUL_CHOICE_7, topicName)
                values.put(QUIZ_NAME__QUIZ_MUL_CHOICE_7, quizName)
                values.put(QUESTION__QUIZ_MUL_CHOICE_7, question)
                values.put(CHOICE_A__QUIZ_MUL_CHOICE_7, choiceA)
                values.put(CHOICE_B__QUIZ_MUL_CHOICE_7, choiceB)
                values.put(CHOICE_C__QUIZ_MUL_CHOICE_7, choiceC)
                values.put(CHOICE_D__QUIZ_MUL_CHOICE_7, choiceD)
                values.put(CHOICE_E__QUIZ_MUL_CHOICE_7, choiceE)
                values.put(CHOICE_F__QUIZ_MUL_CHOICE_7, choiceF)
                values.put(CHOICE_G__QUIZ_MUL_CHOICE_7, choiceG)
                values.put(ANSWER__QUIZ_MUL_CHOICE_7, answer)
                values.put(INSTRUCTUON, instruction)

                // Insert the data into the SQLite database
                val db = this.writableDatabase
                db.insert(TABLE_NAME_QUIZ_MUL_CHOICE_7, null, values)
            }
            Log.e("SQLite: ", "Import complete for TABLE_NAME_QUIZ_MUL_CHOICE_7!!")
        }.addOnFailureListener { e ->
            Log.w("Error fetching documents", e)
        }
    }

    fun TABLE_NAME_QUIZ_REARRANGE_IMPORT() {
        // Get a reference to the Firestore collection
        val collection = dbFirestore.collection("TABLE_NAME_QUIZ_REARRANGE")

        // Fetch all documents from the collection
        collection.get().addOnSuccessListener { documents ->
            for (document in documents) {
                val id = document.getLong(ID_QUIZ_QUIZ_REARRANGE)
                val topicName = document.getString(TOPIC_NAME_QUIZ_REARRANGE)
                val quizName = document.getString(QUIZ_NAME_QUIZ_REARRANGE)
                val statementOne = document.getString(STATEMENT_ONE_QUIZ_REARRANGE)
                val statementTwo = document.getString(STATEMENT_TWO_QUIZ_REARRANGE)
                val statementThree = document.getString(STATEMENT_THREE_QUIZ_REARRANGE)
                val statementCorrect = document.getString(STATEMENT_CORRECT_QUIZ_REARRANGE)
                val instruction = document.getString(INSTRUCTUON)

                // Create a ContentValues object
                val values = ContentValues()
                values.put(ID_QUIZ_QUIZ_REARRANGE, id)
                values.put(TOPIC_NAME_QUIZ_REARRANGE, topicName)
                values.put(QUIZ_NAME_QUIZ_REARRANGE, quizName)
                values.put(STATEMENT_ONE_QUIZ_REARRANGE, statementOne)
                values.put(STATEMENT_TWO_QUIZ_REARRANGE, statementTwo)
                values.put(STATEMENT_THREE_QUIZ_REARRANGE, statementThree)
                values.put(STATEMENT_CORRECT_QUIZ_REARRANGE, statementCorrect)
                values.put(INSTRUCTUON, instruction)

                // Insert the data into the SQLite database
                val db = this.writableDatabase
                db.insert(TABLE_NAME_QUIZ_REARRANGE, null, values)
            }
            Log.e("SQLite: ", "Import complete for TABLE_NAME_QUIZ_REARRANGE!!")
        }.addOnFailureListener { e ->
            Log.w("Error fetching documents", e)
        }
    }

    fun TABLE_NAME_QUIZ_LIST_IMPORT() {
        // Get a reference to the Firestore collection
        val collection = dbFirestore.collection("TABLE_NAME_QUIZ_LIST")

        // Fetch all documents from the collection
        collection.get().addOnSuccessListener { documents ->
            for (document in documents) {
                val id = document.getLong(QUIZ_LIST_ID)
                val model = document.getString(QUIZ_LIST_QUIZ_MODEL)
                val name = document.getString(QUIZ_LIST_QUIZ_NAME)
                val topic = document.getString(QUIZ_LIST_TOPIC_NAME)

                // Create a ContentValues object
                val values = ContentValues()
                values.put(QUIZ_LIST_ID, id)
                values.put(QUIZ_LIST_QUIZ_MODEL, model)
                values.put(QUIZ_LIST_QUIZ_NAME, name)
                values.put(QUIZ_LIST_TOPIC_NAME, topic)

                // Insert the data into the SQLite database
                val db = this.writableDatabase
                db.insert(TABLE_NAME_QUIZ_LIST, null, values)
            }
            Log.e("SQLite: ", "Import complete!!")
        }.addOnFailureListener { e ->
            Log.w("Error fetching documents", e)
        }
    }



    fun exportDbToFirestore(): Boolean{
        val success : Boolean
        try {
            TABLE_NAME_QUIZ_LIST()
            TABLE_NAME_SYNTAX_ONE()
            TABLE_NAME_QUIZ_MUL_CHOICE_2()
            TABLE_NAME_QUIZ_MUL_CHOICE_6()
            TABLE_NAME_QUIZ_MUL_CHOICE_7()
            TABLE_NAME_QUIZ_REARRANGE()

        }catch (e: Exception){
            Log.e("DBHelper", e.message.toString())
        }finally {
            success = true
        }
        return success
    }

    fun TABLE_NAME_QUIZ_LIST(){
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME_QUIZ_LIST", null)
        Log.e("Firestore: ", "Trying to access database")
        if (cursor.moveToFirst()) {
            Log.e("Firestore: ", "Entered database")
            do {
                val jsonObject = JSONObject()
                val idIndex = cursor.getColumnIndex(QUIZ_LIST_ID)
                val modelIndex = cursor.getColumnIndex(QUIZ_LIST_QUIZ_MODEL)
                val nameIndex = cursor.getColumnIndex(QUIZ_LIST_QUIZ_NAME)
                val topicIndex = cursor.getColumnIndex(QUIZ_LIST_TOPIC_NAME)

                if (idIndex != -1) jsonObject.put(QUIZ_LIST_ID, cursor.getInt(idIndex))
                if (modelIndex != -1) jsonObject.put(QUIZ_LIST_QUIZ_MODEL, cursor.getString(modelIndex))
                if (nameIndex != -1) jsonObject.put(QUIZ_LIST_QUIZ_NAME, cursor.getString(nameIndex))
                if (topicIndex != -1) jsonObject.put(QUIZ_LIST_TOPIC_NAME, cursor.getString(topicIndex))


                // Convert the JSONObject to a Map
                val map = Gson().fromJson(jsonObject.toString(), HashMap::class.java)

                // Add a new document with a generated ID
                dbFirestore.collection("TABLE_NAME_QUIZ_LIST")
                    .add(map)
                    .addOnSuccessListener { documentReference ->
                        Log.d("DocumentSnapshot added with ID: ", documentReference.id)
                    }
                    .addOnFailureListener { e ->
                        Log.w("Error adding document", e)
                    }
            } while (cursor.moveToNext())
            Log.e("Firestore: ", "Export complete!!")
        }
        cursor.close()
    }

    fun TABLE_NAME_SYNTAX_ONE(){
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME_SYNTAX_ONE", null)
        Log.e("Firestore: ", "Trying to access database")
        if (cursor.moveToFirst()) {
            Log.e("Firestore: ", "Entered database")
            do {
                val jsonObject = JSONObject()
                val idIndex = cursor.getColumnIndex(ID)
                val topicNameIndex = cursor.getColumnIndex(TOPIC_NAME)
                val quizNameIndex = cursor.getColumnIndex(QUIZ_NAME)
                val questionIndex = cursor.getColumnIndex(QUESTION)
                val choiceAIndex = cursor.getColumnIndex(CHOICE_A)
                val choiceBIndex = cursor.getColumnIndex(CHOICE_B)
                val choiceCIndex = cursor.getColumnIndex(CHOICE_C)
                val choiceDIndex = cursor.getColumnIndex(CHOICE_D)
                val answerIndex = cursor.getColumnIndex(ANSWER)
                val instruction = cursor.getColumnIndex(INSTRUCTUON)

                if (instruction != -1) jsonObject.put(INSTRUCTUON, cursor.getString(instruction))
                if (idIndex != -1) jsonObject.put(ID, cursor.getInt(idIndex))
                if (topicNameIndex != -1) jsonObject.put(TOPIC_NAME, cursor.getString(topicNameIndex))
                if (quizNameIndex != -1) jsonObject.put(QUIZ_NAME, cursor.getString(quizNameIndex))
                if (questionIndex != -1) jsonObject.put(QUESTION, cursor.getString(questionIndex))
                if (choiceAIndex != -1) jsonObject.put(CHOICE_A, cursor.getString(choiceAIndex))
                if (choiceBIndex != -1) jsonObject.put(CHOICE_B, cursor.getString(choiceBIndex))
                if (choiceCIndex != -1) jsonObject.put(CHOICE_C, cursor.getString(choiceCIndex))
                if (choiceDIndex != -1) jsonObject.put(CHOICE_D, cursor.getString(choiceDIndex))
                if (answerIndex != -1) jsonObject.put(ANSWER, cursor.getString(answerIndex))

                // Convert the JSONObject to a Map
                val map = Gson().fromJson(jsonObject.toString(), HashMap::class.java)

                // Add a new document with a generated ID
                dbFirestore.collection("TABLE_NAME_SYNTAX_ONE")
                    .add(map)
                    .addOnSuccessListener { documentReference ->
                        Log.d("DocumentSnapshot added with ID: ", documentReference.id)
                    }
                    .addOnFailureListener { e ->
                        Log.w("Error adding document", e)
                    }
            } while (cursor.moveToNext())
            Log.e("Firestore: ", "Export complete!!")
        }
        cursor.close()
    }

    fun TABLE_NAME_QUIZ_MUL_CHOICE_2(){
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME_QUIZ_MUL_CHOICE_2", null)
        Log.e("Firestore: ", "Trying to access database")
        if (cursor.moveToFirst()) {
            Log.e("Firestore: ", "Entered database")
            do {
                val jsonObject = JSONObject()
                val idIndex = cursor.getColumnIndex(ID_QUIZ_MUL_CHOICE_2)
                val topicNameIndex = cursor.getColumnIndex(TOPIC_NAME__QUIZ_MUL_CHOICE_2)
                val quizNameIndex = cursor.getColumnIndex(QUIZ_NAME__QUIZ_MUL_CHOICE_2)
                val questionIndex = cursor.getColumnIndex(QUESTION__QUIZ_MUL_CHOICE_2)
                val choiceAIndex = cursor.getColumnIndex(CHOICE_A__QUIZ_MUL_CHOICE_2)
                val choiceBIndex = cursor.getColumnIndex(CHOICE_B__QUIZ_MUL_CHOICE_2)
                val answerIndex = cursor.getColumnIndex(ANSWER__QUIZ_MUL_CHOICE_2)
                val instruction = cursor.getColumnIndex(INSTRUCTUON)

                if (instruction != -1) jsonObject.put(INSTRUCTUON, cursor.getString(instruction))
                if (idIndex != -1) jsonObject.put(ID_QUIZ_MUL_CHOICE_2, cursor.getInt(idIndex))
                if (topicNameIndex != -1) jsonObject.put(TOPIC_NAME__QUIZ_MUL_CHOICE_2, cursor.getString(topicNameIndex))
                if (quizNameIndex != -1) jsonObject.put(QUIZ_NAME__QUIZ_MUL_CHOICE_2, cursor.getString(quizNameIndex))
                if (questionIndex != -1) jsonObject.put(QUESTION__QUIZ_MUL_CHOICE_2, cursor.getString(questionIndex))
                if (choiceAIndex != -1) jsonObject.put(CHOICE_A__QUIZ_MUL_CHOICE_2, cursor.getString(choiceAIndex))
                if (choiceBIndex != -1) jsonObject.put(CHOICE_B__QUIZ_MUL_CHOICE_2, cursor.getString(choiceBIndex))
                if (answerIndex != -1) jsonObject.put(ANSWER__QUIZ_MUL_CHOICE_2, cursor.getString(answerIndex))

                // Convert the JSONObject to a Map
                val map = Gson().fromJson(jsonObject.toString(), HashMap::class.java)

                // Add a new document with a generated ID
                dbFirestore.collection("TABLE_NAME_QUIZ_MUL_CHOICE_2")
                    .add(map)
                    .addOnSuccessListener { documentReference ->
                        Log.d("DocumentSnapshot added with ID: ", documentReference.id)
                    }
                    .addOnFailureListener { e ->
                        Log.w("Error adding document", e)
                    }
            } while (cursor.moveToNext())
            Log.e("Firestore: ", "Export complete!!")
        }
        cursor.close()
    }

    fun TABLE_NAME_QUIZ_MUL_CHOICE_6(){
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME_QUIZ_MUL_CHOICE_6", null)
        Log.e("Firestore: ", "Trying to access database")
        if (cursor.moveToFirst()) {
            Log.e("Firestore: ", "Entered database")
            do {
                val jsonObject = JSONObject()
                val idIndex = cursor.getColumnIndex(ID_QUIZ_MUL_CHOICE_6)
                val topicNameIndex = cursor.getColumnIndex(TOPIC_NAME__QUIZ_MUL_CHOICE_6)
                val quizNameIndex = cursor.getColumnIndex(QUIZ_NAME__QUIZ_MUL_CHOICE_6)
                val questionIndex = cursor.getColumnIndex(QUESTION__QUIZ_MUL_CHOICE_6)
                val choiceAIndex = cursor.getColumnIndex(CHOICE_A__QUIZ_MUL_CHOICE_6)
                val choiceBIndex = cursor.getColumnIndex(CHOICE_B__QUIZ_MUL_CHOICE_6)
                val choiceCIndex = cursor.getColumnIndex(CHOICE_C__QUIZ_MUL_CHOICE_6)
                val choiceDIndex = cursor.getColumnIndex(CHOICE_D__QUIZ_MUL_CHOICE_6)
                val choiceEIndex = cursor.getColumnIndex(CHOICE_E__QUIZ_MUL_CHOICE_6)
                val choiceFIndex = cursor.getColumnIndex(CHOICE_F__QUIZ_MUL_CHOICE_6)
                val answerIndex = cursor.getColumnIndex(ANSWER__QUIZ_MUL_CHOICE_6)
                val instruction = cursor.getColumnIndex(INSTRUCTUON)

                if (instruction != -1) jsonObject.put(INSTRUCTUON, cursor.getString(instruction))
                if (idIndex != -1) jsonObject.put(ID_QUIZ_MUL_CHOICE_6, cursor.getInt(idIndex))
                if (topicNameIndex != -1) jsonObject.put(TOPIC_NAME__QUIZ_MUL_CHOICE_6, cursor.getString(topicNameIndex))
                if (quizNameIndex != -1) jsonObject.put(QUIZ_NAME__QUIZ_MUL_CHOICE_6, cursor.getString(quizNameIndex))
                if (questionIndex != -1) jsonObject.put(QUESTION__QUIZ_MUL_CHOICE_6, cursor.getString(questionIndex))
                if (choiceAIndex != -1) jsonObject.put(CHOICE_A__QUIZ_MUL_CHOICE_6, cursor.getString(choiceAIndex))
                if (choiceBIndex != -1) jsonObject.put(CHOICE_B__QUIZ_MUL_CHOICE_6, cursor.getString(choiceBIndex))
                if (choiceCIndex != -1) jsonObject.put(CHOICE_C__QUIZ_MUL_CHOICE_6, cursor.getString(choiceCIndex))
                if (choiceDIndex != -1) jsonObject.put(CHOICE_D__QUIZ_MUL_CHOICE_6, cursor.getString(choiceDIndex))
                if (choiceEIndex != -1) jsonObject.put(CHOICE_E__QUIZ_MUL_CHOICE_6, cursor.getString(choiceEIndex))
                if (choiceFIndex != -1) jsonObject.put(CHOICE_F__QUIZ_MUL_CHOICE_6, cursor.getString(choiceFIndex))
                if (answerIndex != -1) jsonObject.put(ANSWER__QUIZ_MUL_CHOICE_6, cursor.getString(answerIndex))

                // Convert the JSONObject to a Map
                val map = Gson().fromJson(jsonObject.toString(), HashMap::class.java)

                // Add a new document with a generated ID
                dbFirestore.collection("TABLE_NAME_QUIZ_MUL_CHOICE_6")
                    .add(map)
                    .addOnSuccessListener { documentReference ->
                        Log.d("DocumentSnapshot added with ID: ", documentReference.id)
                    }
                    .addOnFailureListener { e ->
                        Log.w("Error adding document", e)
                    }
            } while (cursor.moveToNext())
            Log.e("Firestore: ", "Export complete!!")
        }
        cursor.close()
    }

    fun TABLE_NAME_QUIZ_MUL_CHOICE_7(){
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME_QUIZ_MUL_CHOICE_7", null)
        Log.e("Firestore: ", "Trying to access database")
        if (cursor.moveToFirst()) {
            Log.e("Firestore: ", "Entered database")
            do {
                val jsonObject = JSONObject()
                val idIndex = cursor.getColumnIndex(ID_QUIZ_MUL_CHOICE_7)
                val topicNameIndex = cursor.getColumnIndex(TOPIC_NAME__QUIZ_MUL_CHOICE_7)
                val quizNameIndex = cursor.getColumnIndex(QUIZ_NAME__QUIZ_MUL_CHOICE_7)
                val questionIndex = cursor.getColumnIndex(QUESTION__QUIZ_MUL_CHOICE_7)
                val choiceAIndex = cursor.getColumnIndex(CHOICE_A__QUIZ_MUL_CHOICE_7)
                val choiceBIndex = cursor.getColumnIndex(CHOICE_B__QUIZ_MUL_CHOICE_7)
                val choiceCIndex = cursor.getColumnIndex(CHOICE_C__QUIZ_MUL_CHOICE_7)
                val choiceDIndex = cursor.getColumnIndex(CHOICE_D__QUIZ_MUL_CHOICE_7)
                val choiceEIndex = cursor.getColumnIndex(CHOICE_E__QUIZ_MUL_CHOICE_7)
                val choiceFIndex = cursor.getColumnIndex(CHOICE_F__QUIZ_MUL_CHOICE_7)
                val choiceGIndex = cursor.getColumnIndex(CHOICE_G__QUIZ_MUL_CHOICE_7)
                val answerIndex = cursor.getColumnIndex(ANSWER__QUIZ_MUL_CHOICE_7)
                val instruction = cursor.getColumnIndex(INSTRUCTUON)

                if (instruction != -1) jsonObject.put(INSTRUCTUON, cursor.getString(instruction))
                if (idIndex != -1) jsonObject.put(ID_QUIZ_MUL_CHOICE_7, cursor.getInt(idIndex))
                if (topicNameIndex != -1) jsonObject.put(TOPIC_NAME__QUIZ_MUL_CHOICE_7, cursor.getString(topicNameIndex))
                if (quizNameIndex != -1) jsonObject.put(QUIZ_NAME__QUIZ_MUL_CHOICE_7, cursor.getString(quizNameIndex))
                if (questionIndex != -1) jsonObject.put(QUESTION__QUIZ_MUL_CHOICE_7, cursor.getString(questionIndex))
                if (choiceAIndex != -1) jsonObject.put(CHOICE_A__QUIZ_MUL_CHOICE_7, cursor.getString(choiceAIndex))
                if (choiceBIndex != -1) jsonObject.put(CHOICE_B__QUIZ_MUL_CHOICE_7, cursor.getString(choiceBIndex))
                if (choiceCIndex != -1) jsonObject.put(CHOICE_C__QUIZ_MUL_CHOICE_7, cursor.getString(choiceCIndex))
                if (choiceDIndex != -1) jsonObject.put(CHOICE_D__QUIZ_MUL_CHOICE_7, cursor.getString(choiceDIndex))
                if (choiceEIndex != -1) jsonObject.put(CHOICE_E__QUIZ_MUL_CHOICE_7, cursor.getString(choiceEIndex))
                if (choiceFIndex != -1) jsonObject.put(CHOICE_F__QUIZ_MUL_CHOICE_7, cursor.getString(choiceFIndex))
                if (choiceGIndex != -1) jsonObject.put(CHOICE_G__QUIZ_MUL_CHOICE_7, cursor.getString(choiceGIndex))
                if (answerIndex != -1) jsonObject.put(ANSWER__QUIZ_MUL_CHOICE_7, cursor.getString(answerIndex))

                // Convert the JSONObject to a Map
                val map = Gson().fromJson(jsonObject.toString(), HashMap::class.java)

                // Add a new document with a generated ID
                dbFirestore.collection("TABLE_NAME_QUIZ_MUL_CHOICE_7")
                    .add(map)
                    .addOnSuccessListener { documentReference ->
                        Log.d("DocumentSnapshot added with ID: ", documentReference.id)
                    }
                    .addOnFailureListener { e ->
                        Log.w("Error adding document", e)
                    }
            } while (cursor.moveToNext())
            Log.e("Firestore: ", "Export complete!!")
        }
        cursor.close()
    }

    fun TABLE_NAME_QUIZ_REARRANGE(){
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME_QUIZ_REARRANGE", null)
        Log.e("Firestore: ", "Trying to access database")
        if (cursor.moveToFirst()) {
            Log.e("Firestore: ", "Entered database")
            do {
                val jsonObject = JSONObject()
                val idIndex = cursor.getColumnIndex(ID_QUIZ_QUIZ_REARRANGE)
                val topicNameIndex = cursor.getColumnIndex(TOPIC_NAME_QUIZ_REARRANGE)
                val quizNameIndex = cursor.getColumnIndex(QUIZ_NAME_QUIZ_REARRANGE)
                val statementOneIndex = cursor.getColumnIndex(STATEMENT_ONE_QUIZ_REARRANGE)
                val statementTwoIndex = cursor.getColumnIndex(STATEMENT_TWO_QUIZ_REARRANGE)
                val statementThreeIndex = cursor.getColumnIndex(STATEMENT_THREE_QUIZ_REARRANGE)
                val statementCorrectIndex = cursor.getColumnIndex(STATEMENT_CORRECT_QUIZ_REARRANGE)
                val instruction = cursor.getColumnIndex(INSTRUCTUON)

                if (instruction != -1) jsonObject.put(INSTRUCTUON, cursor.getString(instruction))
                if (idIndex != -1) jsonObject.put(ID_QUIZ_QUIZ_REARRANGE, cursor.getInt(idIndex))
                if (topicNameIndex != -1) jsonObject.put(TOPIC_NAME_QUIZ_REARRANGE, cursor.getString(topicNameIndex))
                if (quizNameIndex != -1) jsonObject.put(QUIZ_NAME_QUIZ_REARRANGE, cursor.getString(quizNameIndex))
                if (statementOneIndex != -1) jsonObject.put(STATEMENT_ONE_QUIZ_REARRANGE, cursor.getString(statementOneIndex))
                if (statementTwoIndex != -1) jsonObject.put(STATEMENT_TWO_QUIZ_REARRANGE, cursor.getString(statementTwoIndex))
                if (statementThreeIndex != -1) jsonObject.put(STATEMENT_THREE_QUIZ_REARRANGE, cursor.getString(statementThreeIndex))
                if (statementCorrectIndex != -1) jsonObject.put(STATEMENT_CORRECT_QUIZ_REARRANGE, cursor.getString(statementCorrectIndex))

                // Convert the JSONObject to a Map
                val map = Gson().fromJson(jsonObject.toString(), HashMap::class.java)

                // Add a new document with a generated ID
                dbFirestore.collection("TABLE_NAME_QUIZ_REARRANGE")
                    .add(map)
                    .addOnSuccessListener { documentReference ->
                        Log.d("DocumentSnapshot added with ID: ", documentReference.id)
                    }
                    .addOnFailureListener { e ->
                        Log.w("Error adding document", e)
                    }
            } while (cursor.moveToNext())
            Log.e("Firestore: ", "Export complete!!")
        }
        cursor.close()
    }

    fun deleteQuiz() : Boolean {
        Log.e("Firestore: ", "Deleting data..")
        try {
            clearQuizListData()
            clearQuizRearrange()
            clearQuizMulChoice7()
            clearQuizMulChoice2()
            clearQuizMulChoice6()
            clearSyntaxOne()
            Log.e("Firestore: ", "Success")
        }catch (e: Exception){
            throw e
        }
        return true
    }
    fun clearQuizListData() {
        val db = getWritableDatabase()
        val deleteStatement = "DELETE FROM $TABLE_NAME_QUIZ_LIST"
        db.execSQL(deleteStatement)
        db.close()
    }

    fun clearQuizRearrange() {
        val db = getWritableDatabase()
        val deleteStatement = "DELETE FROM $TABLE_NAME_QUIZ_REARRANGE"
        db.execSQL(deleteStatement)
        db.close()
    }

    fun clearQuizMulChoice7() {
        val db = getWritableDatabase()
        val deleteStatement = "DELETE FROM $TABLE_NAME_QUIZ_MUL_CHOICE_7"
        db.execSQL(deleteStatement)
        db.close()
    }

    fun clearQuizMulChoice2() {
        val db = getWritableDatabase()
        val deleteStatement = "DELETE FROM $TABLE_NAME_QUIZ_MUL_CHOICE_2"
        db.execSQL(deleteStatement)
        db.close()
    }

    fun clearQuizMulChoice6() {
        val db = getWritableDatabase()
        val deleteStatement = "DELETE FROM $TABLE_NAME_QUIZ_MUL_CHOICE_6"
        db.execSQL(deleteStatement)
        db.close()
    }

    fun clearSyntaxOne() {
        val db = getWritableDatabase()
        val deleteStatement = "DELETE FROM $TABLE_NAME_SYNTAX_ONE"
        db.execSQL(deleteStatement)
        db.close()
    }

}