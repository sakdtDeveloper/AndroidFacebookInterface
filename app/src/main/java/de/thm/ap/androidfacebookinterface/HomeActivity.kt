package de.thm.ap.androidfacebookinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



      val listPost:ListView=findViewById(R.id.listPosts)
       val postList= arrayListOf(
           Post("sommer","couche de soleil, plage , ibiza",R.drawable.image1),
           Post("ocean"," blue, filipin",R.drawable.image2),
           Post("Post3","couche de soleil, plage , ibiza",R.drawable.image3),
           Post("Post4","sonido",R.drawable.image4),
           Post("Post5","amaterazu",R.drawable.image5)
       )
        listPost.adapter=PostAdapter(this,R.layout.item_post,postList
        )

    }
}