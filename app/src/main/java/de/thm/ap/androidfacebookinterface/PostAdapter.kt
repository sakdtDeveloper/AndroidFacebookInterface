package de.thm.ap.androidfacebookinterface

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView

class PostAdapter(
    var mContext:Context,
    var ressource:Int,
    var values: ArrayList<Post>
):ArrayAdapter<Post>(mContext,ressource,values) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //recuperer l'une des valeur du tablo a une position quelquonk
        val post= values[position]

        //convertir item_post en un view
        //LayoutInflater es un convertisseur d'xml en view
        val convert_item_post_in_view=LayoutInflater.from(mContext).inflate(ressource,parent,false)

        //initialisation des des variables en utilisan la view creer
        val title:TextView=convert_item_post_in_view.findViewById(R.id.title)
        val description:TextView=convert_item_post_in_view.findViewById(R.id.description)
        val image:ImageView=convert_item_post_in_view.findViewById(R.id.image)



        title.text=post.title
        description.text=post.description
        image.setImageResource(post.image)

        //ajouter un ecouteur a un popmenu
        val imageShowPopup:ImageView=convert_item_post_in_view.findViewById(R.id.show_popup)

        imageShowPopup.setOnClickListener{
            val popupMenu=PopupMenu(mContext,imageShowPopup)
            popupMenu.menuInflater.inflate(R.menu.list_popup_menu, popupMenu.menu)
            popupMenu.show()

            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.item_show->{
                        Intent(mContext,PostDetailActivity::class.java).apply {

                            putExtra("title",post.title)
                            putExtra("description",post.description)
                            putExtra("image",post.image)

                            mContext.startActivity(this)
                        }
                    }
                    R.id.item_delete->{
                       values.removeAt(position)
                        notifyDataSetChanged()
                    }
                }

                true
            }
        }

        return convert_item_post_in_view
    }
}