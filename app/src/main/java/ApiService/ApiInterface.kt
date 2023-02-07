package ApiService

import Models.modelData
import Models.todosModelItem
import Models.zenModelItem
import retrofit2.Call


import retrofit2.http.GET

interface ApiInterface {

    // https://meme-api.com/gimme

        @GET("/gimme")
        fun getMemes(): Call<modelData>

   // https://jsonplaceholder.typicode.com/todos
        @GET("/todos")
        fun getTodos():Call<List<todosModelItem>>

    @GET("/todos")
    suspend  fun getUserTodos(): List<todosModelItem>

   // https://zenquotes.io/api/quotes
    @GET("/quotes")
    suspend fun getUserZen(): List<zenModelItem>


}

