package com.example.andr_lab_5

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RequestService {
    private val URL = "https://jsonplaceholder.typicode.com/posts";
    private lateinit var requestQueue: RequestQueue;

    constructor(context: Context) {
        requestQueue = Volley.newRequestQueue(context)
    }

    internal inline fun <reified T> Gson.fromJson(json: String) =
        fromJson<T>(json, object : TypeToken<T>() {}.type)

    fun getUsers(responsePresenter: (List<ResponseDto>) -> Unit) {
        val request = StringRequest(
            URL, { response ->
                if (null != response) {
                    val gson = Gson()
                    val responseList: List<ResponseDto> = gson.fromJson(response)
                    println(responseList)
                    responsePresenter.invoke(responseList)
                }
            }, { println(it) }
        );
        print(request)
        requestQueue.add(request)
    }


}