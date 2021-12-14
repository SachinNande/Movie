package com.saveo.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saveo.movies.R
import com.saveo.movies.model.MovieDetailItem

class RecyclerViewAdapter :RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> (){
    var items = ArrayList<MovieDetailItem>()
    fun setUpdatedData(items: ArrayList<MovieDetailItem>){
        this.items=items
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val imageThumb = view.findViewById<ImageView>(R.id.imageThumb)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDesc = view.findViewById<TextView>(R.id.tvDesc)

        fun bind(data: MovieDetailItem){
            tvTitle.text=data.title
            tvDesc.text=data.body

//            val url = data.
//            Picasso.get()
//                .load(url)
//                .into(imageThumb)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}