package com.example.workbookapp.model

import java.io.Serializable

class QuizListModel: Serializable {
    var id : Int = 0
    var quiz_model : String = ""
    var quiz_name : String = ""
    var topic_name : String? = ""
}