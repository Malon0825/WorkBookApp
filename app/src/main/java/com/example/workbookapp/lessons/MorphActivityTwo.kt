package com.example.workbookapp.lessons

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import com.example.workbookapp.R

class MorphActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morph_two)


        val textView = findViewById<TextView>(R.id.textViewInstructionContent)

        textView.apply {
            text = getString(R.string.morph_two_instruction) // Get the text from strings.xml
        }
        textView.setMovementMethod(ScrollingMovementMethod())




        val buttonCompounding = findViewById<Button>(R.id.buttonCompounding)
        buttonCompounding.setOnClickListener {

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
                text = "Compounding"
            }
            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.Compounding)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val buttonBlending = findViewById<Button>(R.id.buttonBlending)
        buttonBlending.setOnClickListener {

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
                text = "Blending"
            }

            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.Blending)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val buttonBackformation = findViewById<Button>(R.id.buttonBackformation)
        buttonBackformation.setOnClickListener {

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
                text = "Backformation"
            }

            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.Backformation)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val buttonConversion = findViewById<Button>(R.id.buttonConversion)
        buttonConversion.setOnClickListener {

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
                text = "Conversion"
            }

            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.Conversion)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

    }
}