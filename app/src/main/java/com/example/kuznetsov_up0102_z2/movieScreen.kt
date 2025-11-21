package com.example.kuznetsov_up0102_z2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import org.json.JSONObject

class movieScreen : AppCompatActivity() {

    lateinit var poster : String
    private lateinit var itemImageView : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_screen)
        itemImageView = findViewById(R.id.imageView)
        getRequest()
        Picasso.get().load("https://www.omdbapi.com/?i=tt3896198&apikey=daad32aa")
            .placeholder(R.drawable.bill_up_close)
            .into(itemImageView)
    }
    private fun getRequest() {
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Method.GET,
            "https://www.omdbapi.com/?i=tt3896198&apikey=daad32aa",
            { response ->
                try {
                    val obj = JSONObject(response)
                    poster = obj.getString("Poster")



                } catch (_: Exception) {

                }
            },
            { _ ->

            }
        ) {

        }

        queue.add(stringRequest)
    }


}