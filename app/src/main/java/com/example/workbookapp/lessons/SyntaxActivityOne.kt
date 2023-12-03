package com.example.workbookapp.lessons

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.workbookapp.R


class SyntaxActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syntax_one)

        // Get a reference to the TextView object
        val textView = findViewById<TextView>(R.id.textViewInstructionContent)

        val instructionText = getString(R.string.syntax_one_instruction_content)
        // Set the properties of the TextView object
        textView.apply {
            text = instructionText
        }

        // Enable scrolling on the TextView object
        textView.setMovementMethod(ScrollingMovementMethod())



        val oneOne = findViewById<Button>(R.id.buttonOne)
        oneOne.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.syntax_one_one, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()


            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.sysntaxOneOne)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneTwo = findViewById<Button>(R.id.buttonTwo)
        oneTwo.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.syntax_one_two, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()


            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.sysntaxOneTwo)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneThree = findViewById<Button>(R.id.buttonThree)
        oneThree.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.syntax_one_three, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()


            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.syntaxOneThree)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneFour = findViewById<Button>(R.id.buttonFour)
        oneFour.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.syntax_one_four, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()


            val textViewContent = dialogBinding.findViewById<TextView>(R.id.textViewContent)
            textViewContent.apply {
                text = getString(R.string.syntaxOneFour)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

    }
}