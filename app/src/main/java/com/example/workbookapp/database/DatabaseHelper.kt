package com.example.workbookapp.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.workbookapp.model.AnswersModel
import com.example.workbookapp.model.QuizzesModel
import com.example.workbookapp.model.QuizzesMulChoice2Model
import com.example.workbookapp.model.QuizzesMulChoice6Model
import com.example.workbookapp.model.QuizzesMulChoice7Model
import com.example.workbookapp.model.QuizzesRearangeModel
import com.example.workbookapp.model.ScoreModel
import com.example.workbookapp.quizzes.QuizAddMulChoice2

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object{
        private val DB_NAME = "EnglishWorkbook"
        private val DB_VERSION = 1

        //Quizzes table

        //Quiz multiple choice
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
        val CREATE_QUIZ_MULTIPLE_CHOICE_TABLE = "CREATE TABLE $TABLE_NAME_SYNTAX_ONE ($ID INTEGER PRIMARY KEY, $TOPIC_NAME TEXT, $QUIZ_NAME TEXT, $QUESTION TEXT, $CHOICE_A TEXT, $CHOICE_B TEXT, $CHOICE_C TEXT, $CHOICE_D TEXT, $ANSWER TEXT)"
        p0?.execSQL(CREATE_QUIZ_MULTIPLE_CHOICE_TABLE)

        val CREATE_QUIZ_MULTIPLE_CHOICE_2_TABLE = "CREATE TABLE $TABLE_NAME_QUIZ_MUL_CHOICE_2 ($ID_QUIZ_MUL_CHOICE_2 INTEGER PRIMARY KEY, $TOPIC_NAME__QUIZ_MUL_CHOICE_2 TEXT, $QUIZ_NAME__QUIZ_MUL_CHOICE_2 TEXT, $QUESTION__QUIZ_MUL_CHOICE_2 TEXT, $CHOICE_A__QUIZ_MUL_CHOICE_2 TEXT, $CHOICE_B__QUIZ_MUL_CHOICE_2 TEXT, $ANSWER__QUIZ_MUL_CHOICE_2 TEXT)"
        p0?.execSQL(CREATE_QUIZ_MULTIPLE_CHOICE_2_TABLE)

        val CREATE_QUIZ_MULTIPLE_CHOICE_6_TABLE = "CREATE TABLE $TABLE_NAME_QUIZ_MUL_CHOICE_6 ($ID_QUIZ_MUL_CHOICE_6 INTEGER PRIMARY KEY, $TOPIC_NAME__QUIZ_MUL_CHOICE_6 TEXT, $QUIZ_NAME__QUIZ_MUL_CHOICE_6 TEXT, $QUESTION__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_A__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_B__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_C__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_D__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_E__QUIZ_MUL_CHOICE_6 TEXT, $CHOICE_F__QUIZ_MUL_CHOICE_6 TEXT, $ANSWER__QUIZ_MUL_CHOICE_6 TEXT)"
        p0?.execSQL(CREATE_QUIZ_MULTIPLE_CHOICE_6_TABLE)

        val CREATE_QUIZ_MULTIPLE_CHOICE_7_TABLE = "CREATE TABLE $TABLE_NAME_QUIZ_MUL_CHOICE_7 ($ID_QUIZ_MUL_CHOICE_7 INTEGER PRIMARY KEY, $TOPIC_NAME__QUIZ_MUL_CHOICE_7 TEXT, $QUIZ_NAME__QUIZ_MUL_CHOICE_7 TEXT, $QUESTION__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_A__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_B__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_C__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_D__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_E__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_F__QUIZ_MUL_CHOICE_7 TEXT, $CHOICE_G__QUIZ_MUL_CHOICE_7 TEXT, $ANSWER__QUIZ_MUL_CHOICE_7 TEXT)"
        p0?.execSQL(CREATE_QUIZ_MULTIPLE_CHOICE_7_TABLE)

        val CREATE_QUIZ_REARRANGE = "CREATE TABLE $TABLE_NAME_QUIZ_REARRANGE ($ID_QUIZ_QUIZ_REARRANGE INTEGER PRIMARY KEY, $TOPIC_NAME_QUIZ_REARRANGE TEXT, $QUIZ_NAME_QUIZ_REARRANGE TEXT, $STATEMENT_ONE_QUIZ_REARRANGE TEXT, $STATEMENT_TWO_QUIZ_REARRANGE TEXT, $STATEMENT_THREE_QUIZ_REARRANGE TEXT, $STATEMENT_CORRECT_QUIZ_REARRANGE TEXT)"
        p0?.execSQL(CREATE_QUIZ_REARRANGE)

        val CREATE_ANSWER_MULTIPLE_CHOICE_TABLE = "CREATE TABLE $ANSWERS_TABLE_NAME_SYNTAX_ONE ($ANSWER_ID INTEGER PRIMARY KEY, $QUIZ_NAME TEXT, $QUESTION TEXT, $CHOICE_A TEXT, $CHOICE_B TEXT, $CHOICE_C TEXT, $CHOICE_D TEXT, $ANSWER TEXT)"
        p0?.execSQL(CREATE_ANSWER_MULTIPLE_CHOICE_TABLE)

        val CREATE_SCORES_TABLE = "CREATE TABLE $TABLE_NAME_SCORES ($SCORE_ID INTEGER PRIMARY KEY, $SCORE_QUIZ_NAME TEXT, $SCORE TEXT, $DATE_TAKEN TEXT)"
        p0?.execSQL(CREATE_SCORES_TABLE)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
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


    fun getALlQuiz(): List<QuizzesModel>{
        val quiz_list = ArrayList<QuizzesModel>()
        val db = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME_SYNTAX_ONE"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val quiz = QuizzesModel()
                try {
                    quiz.id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(ID)))
                    quiz.quiz_name = cursor.getString(cursor.getColumnIndexOrThrow(QUIZ_NAME))
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



    fun addQuiz(quiz : QuizzesModel): Boolean{ val db = this.writableDatabase
        val values = ContentValues()
        values.put(TOPIC_NAME, quiz.quiz_topic)
        values.put(QUIZ_NAME, quiz.quiz_name)
        values.put(QUESTION, quiz.question)
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

    fun addQuizMulChoice2(quiz : QuizzesMulChoice2Model): Boolean{ val db = this.writableDatabase
        val values = ContentValues()

        values.put(TOPIC_NAME__QUIZ_MUL_CHOICE_2, quiz.quiz_topic)
        values.put(QUIZ_NAME__QUIZ_MUL_CHOICE_2, quiz.quiz_name)
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

    fun addQuizMulChoice6(quiz : QuizzesMulChoice6Model): Boolean{ val db = this.writableDatabase
        val values = ContentValues()

        values.put(TOPIC_NAME__QUIZ_MUL_CHOICE_6, quiz.quiz_topic)
        values.put(QUIZ_NAME__QUIZ_MUL_CHOICE_6, quiz.quiz_name)
        values.put(QUESTION__QUIZ_MUL_CHOICE_6, quiz.question)
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

    fun addQuizMulChoice7(quiz : QuizzesMulChoice7Model): Boolean{ val db = this.writableDatabase
        val values = ContentValues()

        values.put(TOPIC_NAME__QUIZ_MUL_CHOICE_7, quiz.quiz_topic)
        values.put(QUIZ_NAME__QUIZ_MUL_CHOICE_7, quiz.quiz_name)
        values.put(QUESTION__QUIZ_MUL_CHOICE_7, quiz.question)
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

    fun addQuizRearrange(quiz : QuizzesRearangeModel): Boolean{ val db = this.writableDatabase
        val values = ContentValues()

        values.put(TOPIC_NAME_QUIZ_REARRANGE, quiz.quiz_topic)
        values.put(QUIZ_NAME_QUIZ_REARRANGE, quiz.quiz_name)
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

    fun addScore(score : ScoreModel): Boolean{ val db = this.writableDatabase
        val values = ContentValues()
        values.put(SCORE_QUIZ_NAME, score.quiz_name)
        values.put(SCORE, score.score)

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

}