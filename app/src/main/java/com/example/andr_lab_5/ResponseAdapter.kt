package com.example.andr_lab_5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResponseAdapter : RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder>() {

    private var responses: List<ResponseDto> = ArrayList()

    inner class ResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userIdView: TextView = itemView.findViewById(R.id.userId)
        val titleView: TextView = itemView.findViewById(R.id.title)
        val bodyView: TextView = itemView.findViewById(R.id.body)

        fun bind(resp: ResponseDto) {
            userIdView.text = resp.userId.toString().lines().joinToString("")
            titleView.text = resp.title.toString().lines().joinToString("")
            bodyView.text = resp.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        val responseView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return ResponseViewHolder(responseView)
    }

    override fun getItemCount(): Int {
        return responses.size
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        val currentItem = responses[position]
        holder.bind(currentItem)
    }

    fun setItems(responses: List<ResponseDto>) {
        this.responses = responses
        notifyDataSetChanged()
    }
}