package com.example.andr_lab_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ResponseAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var requestService: RequestService

    override fun onCreate(savedInstanceState: Bundle?) {
        requestService = RequestService(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerViewList)
        adapter = ResponseAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        requestService = RequestService(this)
        requestService.getUsers(adapter::setItems)
    }


}