package com.example.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.adaper.MovieAdapter
import com.example.movielist.model.KinopoiskMovies
import com.example.movielist.model.MovieModel
import com.example.movielist.network.ServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val adapter = MovieAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter

        val service = ServiceFactory.getApiService()

        service.getMovies().enqueue(MoviesCallback())
    }

    inner class MoviesCallback : Callback<KinopoiskMovies>{
        override fun onResponse(
            call: Call<KinopoiskMovies>,
            response: Response<KinopoiskMovies>
        ) {
            response.body()?.let { adapter.addMovies(it.movies) }
        }

        override fun onFailure(call: Call<KinopoiskMovies>, t: Throwable) {
            Log.e(MainActivity::class.simpleName, t.message.toString())
        }

    }
}