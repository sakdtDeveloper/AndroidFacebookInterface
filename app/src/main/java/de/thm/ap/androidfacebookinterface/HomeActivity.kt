package de.thm.ap.androidfacebookinterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

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
           Post("Post5","amaterazu",R.drawable.image5))

        listPost.adapter=PostAdapter(this,R.layout.item_post,postList)

        listPost.setOnItemClickListener { adapterView, view, position, id ->
            Intent(this,PostDetailActivity::class.java).apply {

                putExtra("title",postList[position].title)
                putExtra("description",postList[position].description)
                putExtra("image",postList[position].image)

                startActivity(this)
            }
        }



    }
    //ajouter le menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}