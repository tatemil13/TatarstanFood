package com.example.mytatarstfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth2)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPassword: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val pass = userPassword.text.toString().trim()

            if(login == "" || pass == ""   )
                Toast.makeText(this," какое-то из полей пусто!!!", Toast.LENGTH_LONG).show()
            else{
                val db = DbHelper(this,null)
                val isAuth =  db.getUser(login,pass)


                if(isAuth){
                    Toast.makeText(this,"Пользователь $login вошел", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()


                    val intent = Intent(this, ItemsActivity2::class.java)
                    startActivity(intent)


                }else
                    Toast.makeText(this,"Пользователь $login  нет", Toast.LENGTH_LONG).show()




            }
        }

    }
}
