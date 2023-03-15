package com.example.retrofitdemo2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val context:Context, val list:List<PostModel>):RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    class MyViewHolder(v: View):RecyclerView.ViewHolder(v) {
        val userId:TextView = v.findViewById(R.id.userId)
        val tvid:TextView = v.findViewById(R.id.tvid)
        val title:TextView = v.findViewById(R.id.title)
        val body:TextView = v.findViewById(R.id.body)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.userId.text = list.get(position).userId.toString()
        holder.tvid.text = list.get(position).id.toString()
        holder.title.text = list.get(position).title
        holder.body.text = list.get(position).body
    }

    override fun getItemCount(): Int {
        return list.size
    }
}