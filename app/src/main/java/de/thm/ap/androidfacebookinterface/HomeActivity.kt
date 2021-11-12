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
       val postList= listOf("Post 1","Post 2","Post 3","Post 4","Post 5")
        listPost.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,postList)

    }
}