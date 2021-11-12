package de.thm.ap.androidfacebookinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val identifiant:TextView=findViewById(R.id.identifiant)

        // recuperer l'email envoye par l'activityMain
          val email=intent.getStringExtra("email")
          val password=intent.getStringExtra("password")
        //afficher l'email dans homeActivity
        identifiant.text="email:$email\n password:$password"
    }
}