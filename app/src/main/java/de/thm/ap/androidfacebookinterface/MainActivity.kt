package de.thm.ap.androidfacebookinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val connect:Button=findViewById(R.id.btn_connexion)
        val email:EditText=findViewById(R.id.edt_mail)
        val password:EditText=findViewById(R.id.edt_password)
        val errorPassword:TextView=findViewById(R.id.errorPassword)
        val errorEmail:TextView=findViewById(R.id.errorEmail)

        connect.setOnClickListener {
            errorEmail.visibility=View.GONE
            errorPassword.visibility=View.GONE
            val txtEmail=email.text.toString()
            val txtPassword=password.text.toString()


            if(txtEmail.trim().isEmpty() || txtPassword.trim().isEmpty()) {

                    if (txtEmail.trim().isEmpty()){
                        errorEmail.text="le champ email ne doit pas etre vide"
                        errorEmail.visibility= View.VISIBLE
                    }
                    if (txtPassword.trim().isEmpty()){
                        errorPassword.text="le champ password ne doit pas etre vide"
                        errorPassword.visibility= View.VISIBLE
                    }

            }else{
                val correctEmail="sakdt@web.de"
                val correctPassword="1234"

                if(txtEmail==correctEmail && txtPassword==correctPassword){
                    Toast.makeText(
                        this,
                        "felicitation vous etes connectez",
                        Toast.LENGTH_LONG
                    ).show()
                }else {
                    Toast.makeText(
                        this,
                        "email ou password incorrect!!!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }


        }
    }
}