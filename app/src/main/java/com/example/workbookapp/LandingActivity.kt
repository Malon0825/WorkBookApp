package com.example.workbookapp

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.workbookapp.lessons.MorphActivity

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)


        val user = findViewById<Button>(R.id.buttonUser)
        user.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val oneOne = findViewById<Button>(R.id.buttonAdmin)
        oneOne.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.activity_admin_login, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            val window = myDialog.window
            window?.setGravity(Gravity.CENTER)
            window?.setDimAmount(0.6F)

            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.setCanceledOnTouchOutside(true)
            myDialog.show()

            val username = "admin"
            val password = "password"

            val login = dialogBinding.findViewById<Button>(R.id.buttonLogin)
            login.setOnClickListener{

                val users = dialogBinding.findViewById<EditText>(R.id.editTextUsername)
                val userInput = users.text.toString()

                val pass = dialogBinding.findViewById<EditText>(R.id.editTextPassword)
                val passInput = pass.text.toString()

                if (username == userInput && password == passInput){
                    val intent = Intent(this, AdminActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Wrong username or password!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}