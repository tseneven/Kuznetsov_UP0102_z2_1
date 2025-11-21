package com.example.kuznetsov_up0102_z2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import org.json.JSONObject

class PosterAdapter(val context: Context, private val posters: List<String>) : BaseAdapter() {

    override fun getCount(): Int = posters.size

    override fun getItem(position: Int) = posters[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.lianer_movie, parent, false)

        val image = view.findViewById<ImageView>(R.id.poster_image)

        Picasso.get()
            .load(posters[position])
            .placeholder(R.drawable.bill_up_close)
            .into(image)

        return view
    }
}class movieScreen : AppCompatActivity() {

    private lateinit var listView: ListView
    private val posters = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_screen)

        listView = findViewById(R.id.list)

        loadPosters()
    }

    private fun loadPosters() {
        val queue = Volley.newRequestQueue(this)

        for (i in 1..5) {
            val url = "https://www.omdbapi.com/?i=tt3896198&apikey=daad32aa"

            val request = StringRequest(
                Request.Method.GET, url,
                { response ->
                    val obj = JSONObject(response)
                    val posterUrl = obj.getString("Poster")

                    Log.d("FFFFFFFFFFFFFF", posterUrl)
                    posters.add(posterUrl)

                    if (posters.size == 5) {
                        listView.adapter = PosterAdapter(this, posters)
                    }
                },
                { }
            )

            queue.add(request)
        }
    }
}