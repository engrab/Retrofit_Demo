package com.example.retrofitdemo2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        findViewById<Button>(R.id.button).setOnClickListener {
            getPost()
        }
    }

    private fun getPost() {

        val post = PostService.postInstance.getPost()

        post.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                val list = response.body()
                if (list != null) {

                    recyclerView.adapter = PostAdapter(this@MainActivity, list)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                }

            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }
        })

    }
}