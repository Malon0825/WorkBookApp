package com.example.workbookapp.quizzes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.widget.ImageButton
import com.example.workbookapp.R

class QuizTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_type)

        val buttonTypeOne = findViewById<Button>(R.id.imageButtonOne)
        buttonTypeOne.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.activity_admin_select_quiz_topic, null)
            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()

            val buttonOne = dialogBinding.findViewById<ImageButton>(R.id.imageButtonOne)
            buttonOne.setOnClickListener{
                val passData = "Syntax Topic 1"
                val intent = Intent(this, QuizAddActivity::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonTwo = dialogBinding.findViewById<ImageButton>(R.id.imageButtonTwo)
            buttonTwo.setOnClickListener{
                val passData = "Syntax Topic 2"
                val intent = Intent(this, QuizAddActivity::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonThree = dialogBinding.findViewById<ImageButton>(R.id.imageButtonThree)
            buttonThree.setOnClickListener{
                val passData = "Syntax Topic 3"
                val intent = Intent(this, QuizAddActivity::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFour = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFour)
            buttonFour.setOnClickListener{
                val passData = "Syntax Topic 4"
                val intent = Intent(this, QuizAddActivity::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFive = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFive)
            buttonFive.setOnClickListener{
                val passData = "Syntax Topic 5"
                val intent = Intent(this, QuizAddActivity::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSix = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSix)
            buttonSix.setOnClickListener{
                val passData = "Syntax Topic 6"
                val intent = Intent(this, QuizAddActivity::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSeven = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSeven)
            buttonSeven.setOnClickListener{
                val passData = "Syntax Topic 7"
                val intent = Intent(this, QuizAddActivity::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonEight = dialogBinding.findViewById<ImageButton>(R.id.imageButtonEight)
            buttonEight.setOnClickListener{
                val passData = "Syntax Topic 8"
                val intent = Intent(this, QuizAddActivity::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonNine = dialogBinding.findViewById<ImageButton>(R.id.imageButtonNine)
            buttonNine.setOnClickListener{
                val passData = "Syntax Topic 9"
                val intent = Intent(this, QuizAddActivity::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

        }

        val buttonTypeTwo = findViewById<Button>(R.id.imageButtonTwo)
        buttonTypeTwo.setOnClickListener {

            val dialogBinding =
                layoutInflater.inflate(R.layout.activity_admin_select_quiz_topic, null)
            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()

            val buttonOne = dialogBinding.findViewById<ImageButton>(R.id.imageButtonOne)
            buttonOne.setOnClickListener {
                val passData = "Syntax Topic 1"
                val intent = Intent(this, QuizAddMulChoice6::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonTwo = dialogBinding.findViewById<ImageButton>(R.id.imageButtonTwo)
            buttonTwo.setOnClickListener {
                val passData = "Syntax Topic 2"
                val intent = Intent(this, QuizAddMulChoice6::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonThree = dialogBinding.findViewById<ImageButton>(R.id.imageButtonThree)
            buttonThree.setOnClickListener {
                val passData = "Syntax Topic 3"
                val intent = Intent(this, QuizAddMulChoice6::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFour = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFour)
            buttonFour.setOnClickListener {
                val passData = "Syntax Topic 4"
                val intent = Intent(this, QuizAddMulChoice6::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFive = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFive)
            buttonFive.setOnClickListener {
                val passData = "Syntax Topic 5"
                val intent = Intent(this, QuizAddMulChoice6::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSix = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSix)
            buttonSix.setOnClickListener {
                val passData = "Syntax Topic 6"
                val intent = Intent(this, QuizAddMulChoice6::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSeven = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSeven)
            buttonSeven.setOnClickListener {
                val passData = "Syntax Topic 7"
                val intent = Intent(this, QuizAddMulChoice6::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonEight = dialogBinding.findViewById<ImageButton>(R.id.imageButtonEight)
            buttonEight.setOnClickListener {
                val passData = "Syntax Topic 8"
                val intent = Intent(this, QuizAddMulChoice6::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonNine = dialogBinding.findViewById<ImageButton>(R.id.imageButtonNine)
            buttonNine.setOnClickListener {
                val passData = "Syntax Topic 9"
                val intent = Intent(this, QuizAddMulChoice6::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

        }

        val buttonTypeThree = findViewById<Button>(R.id.imageButtonThree)
        buttonTypeThree.setOnClickListener {

            val dialogBinding =
                layoutInflater.inflate(R.layout.activity_admin_select_quiz_topic, null)
            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()

            val buttonOne = dialogBinding.findViewById<ImageButton>(R.id.imageButtonOne)
            buttonOne.setOnClickListener {
                val passData = "Syntax Topic 1"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonTwo = dialogBinding.findViewById<ImageButton>(R.id.imageButtonTwo)
            buttonTwo.setOnClickListener {
                val passData = "Syntax Topic 2"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonThree = dialogBinding.findViewById<ImageButton>(R.id.imageButtonThree)
            buttonThree.setOnClickListener {
                val passData = "Syntax Topic 3"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFour = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFour)
            buttonFour.setOnClickListener {
                val passData = "Syntax Topic 4"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFive = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFive)
            buttonFive.setOnClickListener {
                val passData = "Syntax Topic 5"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSix = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSix)
            buttonSix.setOnClickListener {
                val passData = "Syntax Topic 6"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSeven = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSeven)
            buttonSeven.setOnClickListener {
                val passData = "Syntax Topic 7"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonEight = dialogBinding.findViewById<ImageButton>(R.id.imageButtonEight)
            buttonEight.setOnClickListener {
                val passData = "Syntax Topic 8"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonNine = dialogBinding.findViewById<ImageButton>(R.id.imageButtonNine)
            buttonNine.setOnClickListener {
                val passData = "Syntax Topic 9"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

        }

        val buttonTypeFour = findViewById<Button>(R.id.imageButtonFour)
        buttonTypeFour.setOnClickListener {

            val dialogBinding =
                layoutInflater.inflate(R.layout.activity_admin_select_quiz_topic, null)
            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()

            val buttonOne = dialogBinding.findViewById<ImageButton>(R.id.imageButtonOne)
            buttonOne.setOnClickListener {
                val passData = "Syntax Topic 1"
                val intent = Intent(this, QuizAddRearange::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonTwo = dialogBinding.findViewById<ImageButton>(R.id.imageButtonTwo)
            buttonTwo.setOnClickListener {
                val passData = "Syntax Topic 2"
                val intent = Intent(this, QuizAddRearange::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonThree = dialogBinding.findViewById<ImageButton>(R.id.imageButtonThree)
            buttonThree.setOnClickListener {
                val passData = "Syntax Topic 3"
                val intent = Intent(this, QuizAddRearange::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFour = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFour)
            buttonFour.setOnClickListener {
                val passData = "Syntax Topic 4"
                val intent = Intent(this, QuizAddRearange::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFive = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFive)
            buttonFive.setOnClickListener {
                val passData = "Syntax Topic 5"
                val intent = Intent(this, QuizAddRearange::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSix = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSix)
            buttonSix.setOnClickListener {
                val passData = "Syntax Topic 6"
                val intent = Intent(this, QuizAddRearange::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSeven = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSeven)
            buttonSeven.setOnClickListener {
                val passData = "Syntax Topic 7"
                val intent = Intent(this, QuizAddRearange::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonEight = dialogBinding.findViewById<ImageButton>(R.id.imageButtonEight)
            buttonEight.setOnClickListener {
                val passData = "Syntax Topic 8"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonNine = dialogBinding.findViewById<ImageButton>(R.id.imageButtonNine)
            buttonNine.setOnClickListener {
                val passData = "Syntax Topic 9"
                val intent = Intent(this, QuizAddMulChoice7::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

        }

        val buttonTypeFive = findViewById<Button>(R.id.imageButtonFive)
        buttonTypeFive.setOnClickListener {

            val dialogBinding =
                layoutInflater.inflate(R.layout.activity_admin_select_quiz_topic, null)
            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()

            val buttonOne = dialogBinding.findViewById<ImageButton>(R.id.imageButtonOne)
            buttonOne.setOnClickListener {
                val passData = "Syntax Topic 1"
                val intent = Intent(this, QuizAddMulChoice2::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonTwo = dialogBinding.findViewById<ImageButton>(R.id.imageButtonTwo)
            buttonTwo.setOnClickListener {
                val passData = "Syntax Topic 2"
                val intent = Intent(this, QuizAddMulChoice2::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonThree = dialogBinding.findViewById<ImageButton>(R.id.imageButtonThree)
            buttonThree.setOnClickListener {
                val passData = "Syntax Topic 3"
                val intent = Intent(this, QuizAddMulChoice2::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFour = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFour)
            buttonFour.setOnClickListener {
                val passData = "Syntax Topic 4"
                val intent = Intent(this, QuizAddMulChoice2::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonFive = dialogBinding.findViewById<ImageButton>(R.id.imageButtonFive)
            buttonFive.setOnClickListener {
                val passData = "Syntax Topic 5"
                val intent = Intent(this, QuizAddMulChoice2::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSix = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSix)
            buttonSix.setOnClickListener {
                val passData = "Syntax Topic 6"
                val intent = Intent(this, QuizAddMulChoice2::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonSeven = dialogBinding.findViewById<ImageButton>(R.id.imageButtonSeven)
            buttonSeven.setOnClickListener {
                val passData = "Syntax Topic 7"
                val intent = Intent(this, QuizAddMulChoice2::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonEight = dialogBinding.findViewById<ImageButton>(R.id.imageButtonEight)
            buttonEight.setOnClickListener {
                val passData = "Syntax Topic 8"
                val intent = Intent(this, QuizAddMulChoice2::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

            val buttonNine = dialogBinding.findViewById<ImageButton>(R.id.imageButtonNine)
            buttonNine.setOnClickListener {
                val passData = "Syntax Topic 9"
                val intent = Intent(this, QuizAddMulChoice2::class.java)
                intent.putExtra("topic", passData)
                startActivity(intent)
            }

        }
    }
}