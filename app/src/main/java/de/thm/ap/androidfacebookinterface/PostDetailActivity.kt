package de.thm.ap.androidfacebookinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PostDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val title:TextView=findViewById(R.id.titleDetail)
        val description:TextView=findViewById(R.id.descriptionDetail)
        val image:ImageView=findViewById(R.id.imageDetail)

        title.text=intent.getStringExtra("title")
        description.text=intent.getStringExtra("description")
        image.setImageResource(intent.getIntExtra("image",0))

        supportActionBar!!.title=title.text
    }
}