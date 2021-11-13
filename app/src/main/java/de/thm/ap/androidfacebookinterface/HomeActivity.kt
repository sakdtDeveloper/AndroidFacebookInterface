package de.thm.ap.androidfacebookinterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class HomeActivity : AppCompatActivity() {

    lateinit var listPost:ListView
     var postList=ArrayList<Post>()
    lateinit var adapter:PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



       listPost=findViewById(R.id.listPosts)
        postList= arrayListOf(
           Post("sommer","couche de soleil, plage , ibiza",R.drawable.image1),
           Post("ocean"," blue, filipin",R.drawable.image2),
           Post("Post3","couche de soleil, plage , ibiza",R.drawable.image3),
           Post("Post4","sonido",R.drawable.image4),
           Post("Post5","amaterazu",R.drawable.image5))

        adapter=PostAdapter(this,R.layout.item_post,postList)
        listPost.adapter=adapter

        listPost.setOnItemClickListener { adapterView, view, position, id ->
            Intent(this,PostDetailActivity::class.java).apply {

                putExtra("title",postList[position].title)
                putExtra("description",postList[position].description)
                putExtra("image",postList[position].image)

                startActivity(this)
            }
        }

       //initialisation du contextMenu sur la liste

        registerForContextMenu(listPost)

    }
    //ajouter le Optionmenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //ajouter des ecouteurs au optionMenu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.addPost->{
              Toast.makeText(this,"add",Toast.LENGTH_LONG).show()
            }
            R.id.setting->{
                Toast.makeText(this,"setting",Toast.LENGTH_LONG).show()
            }
            R.id.logout->{
                Intent(this,MainActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //ajouter un contextMenu

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.list_context_menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    //ajouter un ecouteur au contextMenu

    override fun onContextItemSelected(item: MenuItem): Boolean {

        //recuperer la postion de du item dans la list grace au parametre menuInfo dans oncreateContextMenu
        val position=(item.menuInfo as AdapterView.AdapterContextMenuInfo).position

        when(item.itemId){
            R.id.item_show->{
                Intent(this,PostDetailActivity::class.java).apply {

                    putExtra("title",postList[position].title)
                    putExtra("description",postList[position].description)
                    putExtra("image",postList[position].image)

                    startActivity(this)
                }
            }
            R.id.item_delete->{
              postList.removeAt(position)
                //signaler la suppression a l'adapteur
                adapter.notifyDataSetChanged()
            }
        }
        return super.onContextItemSelected(item)
    }
}