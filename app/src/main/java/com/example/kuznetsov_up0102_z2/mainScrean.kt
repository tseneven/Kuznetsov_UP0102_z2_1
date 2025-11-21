package com.example.kuznetsov_up0102_z2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class mainScrean : AppCompatActivity() {
    lateinit var obs : ImageButton
    lateinit var obs1 : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screan)
        obs = findViewById(R.id.obs)
        obs1 = findViewById(R.id.obs1)

        obs.setOnClickListener{
            val intent : Intent  = Intent(this, chatList::class.java)
            startActivity(intent)
        }

        obs1.setOnClickListener{
            val intent : Intent  = Intent(this, chatList::class.java)
            startActivity(intent)
        }

    }
}