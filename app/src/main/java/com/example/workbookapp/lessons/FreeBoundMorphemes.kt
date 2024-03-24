package com.example.workbookapp.lessons

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.workbookapp.R

class FreeBoundMorphemes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_free_bound_morphemes)

        val oneOne = findViewById<Button>(R.id.buttonOne)
        oneOne.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.display_lesson_content, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()

            val textViewTitle = dialogBinding.findViewById<TextView>(R.id.textViewTitle)
            textViewTitle.apply {
                text = "Free Morphemes"
            }

            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.Free_Morphemes)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneTwo = findViewById<Button>(R.id.buttonTwo)
        oneTwo.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.display_lesson_content, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()

            val textViewTitle = dialogBinding.findViewById<TextView>(R.id.textViewTitle)
            textViewTitle.apply {
                text = "Bound Morphemes"
            }
            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.Bound_Morphemes)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }



    }
}