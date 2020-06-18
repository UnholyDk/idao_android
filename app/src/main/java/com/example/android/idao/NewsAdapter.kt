package com.example.android.idao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val data: List<News>): RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    //var data = listOf<News>()
    //    set(value) {
    //        field = value
    //        notifyDataSetChanged()
    //   }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.header.text = item.header
        holder.body.text = item.body
        holder.date.text = item.date
        holder.author.text = item.authorId.toString()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val header: TextView = itemView.findViewById(R.id.header)
        val body: TextView = itemView.findViewById(R.id.body)
        val date: TextView = itemView.findViewById(R.id.date)
        val author: TextView = itemView.findViewById(R.id.author)
    }
}
