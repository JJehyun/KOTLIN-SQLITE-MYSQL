package com.example.study02

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BoardAdapter(private val context: Context) : RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
    var datas = mutableListOf<BoardData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.board_recycle,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])

        holder.itemView.setOnClickListener {

            val intentS = Intent(holder.itemView?.context,DatailActivity::class.java)
            intentS.putExtra("number","$position")
            ContextCompat.startActivity(holder.itemView.context, intentS,null)
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtName: TextView = itemView.findViewById(R.id.BoardTitle)
        private val txtAge: TextView = itemView.findViewById(R.id.Boardtext01)
        private val imgProfile: ImageView = itemView.findViewById(R.id.imageView)

        private val BoardText02: TextView = itemView.findViewById(R.id.BoardText02)
        private val BoardText03: TextView = itemView.findViewById(R.id.BoardText03)
        private val boardText10: TextView = itemView.findViewById(R.id.boardText10)
        private val boardmessage: TextView = itemView.findViewById(R.id.boardmessage)


        fun bind(item: BoardData) {
            boardmessage.text=item.counterComent
            boardText10.text=item.counter
            txtName.text = item.name
            txtAge.text = item.age.toString()
            BoardText02.text = item.nameone
            BoardText03.text = item.nametwo
            Glide.with(itemView).load(item.img).into(imgProfile)

        }
    }


}