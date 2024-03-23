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




        val oneFour = findViewById<Button>(R.id.buttonFour)
        oneFour.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.morph_two_4, null)

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
                text = getString(R.string.morph_two_four)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneFive = findViewById<Button>(R.id.buttonFive)
        oneFive.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.morph_two_5, null)

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
                text = getString(R.string.morph_two_five)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneSix = findViewById<Button>(R.id.buttonSix)
        oneSix.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.morph_two_6, null)

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
                text = getString(R.string.morph_two_six)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

        val oneSeven = findViewById<Button>(R.id.buttonSeven)
        oneSeven.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.morph_two_7, null)

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
                text = getString(R.string.morph_two_seven)
            }

            textViewContent.setMovementMethod(ScrollingMovementMethod())
        }

    }
}