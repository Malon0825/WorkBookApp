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

class SyntaxActivityFive : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syntax_five)

        // Get a reference to the TextView object
        val textView = findViewById<TextView>(R.id.textViewInstructionContent)

        // Set the properties of the TextView object
        textView.apply {
            text = getString(R.string.syntax_five_instruction) // Get the text from strings.xml
        }

        // Enable scrolling on the TextView object
        textView.setMovementMethod(ScrollingMovementMethod())



        val oneOne = findViewById<Button>(R.id.buttonOne)
        oneOne.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.syntax_five_one, null)

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
                text = getString(R.string.syntax_five_one)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneTwo = findViewById<Button>(R.id.buttonTwo)
        oneTwo.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.syntax_five_two, null)

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
                text = getString(R.string.syntax_five_two)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneThree = findViewById<Button>(R.id.buttonThree)
        oneThree.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.syntax_five_three, null)

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
                text = getString(R.string.syntax_five_three)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneFour = findViewById<Button>(R.id.buttonFour)
        oneFour.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.syntax_five_four, null)

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
                text = getString(R.string.syntax_five_four)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneFive = findViewById<Button>(R.id.buttonFive)
        oneFive.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.syntax_five_five, null)

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
                text = getString(R.string.syntax_five_five)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneSix = findViewById<Button>(R.id.buttonSix)
        oneSix.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.syntax_five_six, null)

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
                text = getString(R.string.syntax_five_six)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneSeven = findViewById<Button>(R.id.buttonSeven)
        oneSeven.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.syntax_five_seven, null)

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
                text = getString(R.string.syntax_five_seven)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

    }
}