package com.example.sampletest.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sampletest.MainActivity
import com.example.sampletest.PostFragment
import com.example.sampletest.R
import com.example.sampletest.model_data.DataModelItem

class PostAdapter(private val context: MainActivity, private val dataModelItem: List<DataModelItem>): RecyclerView.Adapter<PostAdapter.PostListViewHolder>() {

    class PostListViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val mainTv = ItemView.findViewById<TextView>(R.id.tv_title)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view,parent,false)
        return PostListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataModelItem.size
    }

    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        holder.mainTv.text = dataModelItem[position].title
        holder.itemView.setOnClickListener {
            // Handle item click here
            Toast.makeText(holder.itemView.context, "Clicked item ", Toast.LENGTH_SHORT).show()

                context.calli(position)


        }

    }


}
