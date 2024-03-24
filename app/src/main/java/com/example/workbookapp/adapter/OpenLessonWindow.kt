package com.example.workbookapp.adapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.ContentInfo
import android.view.ContextMenu
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.example.workbookapp.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.core.view.get

class OpenLessonWindow {

    fun ShowLessonDialog(context: Context, title: String, content: String){

        try {

            val inflater = ContextCompat.getSystemService(context, LayoutInflater::class.java)
            val dialogBinding = inflater?.inflate(R.layout.display_lesson_content, null)

            val myDialog = Dialog(context)
            myDialog.setContentView(dialogBinding!!)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()

            val textViewTitle = dialogBinding.findViewById<TextView>(R.id.textViewTitle)
            textViewTitle.apply {
                text = title
            }

            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = content
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }catch (e: Exception){
            Log.e("OpenLessonWindow", e.message.toString())
            throw e
        }

    }
}