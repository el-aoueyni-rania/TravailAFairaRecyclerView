package com.example.travailafairarecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyAdapter(private val list: List<Governorate>, private val listener: OnItemClickListener):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var ps : Int = 0
    private var listData: MutableList<Governorate> = list as MutableList<Governorate>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ligne, parent, false)
        val holder = ViewHolder(view)
        return holder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val governorate : Governorate = listData[position]
        holder.bind(governorate)

    }


    override fun getItemCount(): Int {
        return listData.size
    }



     inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView),
         View.OnClickListener {
         private var imageView: ImageView = itemView.findViewById(R.id.img)
         private var textView: TextView = itemView.findViewById(R.id.txt)

         init {
             ItemView.setOnClickListener(this)
         }

         fun bind(governorate: Governorate){
             imageView.setImageResource(governorate.image)
             textView.text = governorate.name
         }


         override fun onClick(p0: View?) {
             ps = adapterPosition
             if (ps !=RecyclerView.NO_POSITION){
                 listener.OnItemClick(ps)
             }
         }

     }



    interface OnItemClickListener {
        fun OnItemClick(position: Int)
    }

}

