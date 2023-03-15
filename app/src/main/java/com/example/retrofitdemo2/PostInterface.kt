package com.example.retrofitdemo2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//https://jsonplaceholder.typicode.com/posts

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
const val POST = "posts"
interface PostInterface {

    @GET(POST)
    fun getPost():Call<List<PostModel>>

}

object PostService{

    val postInstance: PostInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        postInstance = retrofit.create(PostInterface::class.java)
    }
}