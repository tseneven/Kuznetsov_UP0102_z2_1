package com.example.kuznetsov_up0102_z2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class chatList : AppCompatActivity() {
    lateinit var list: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)

        list = findViewById(R.id.list)

        val names = arrayOf(
            "Lucifer", "The Witcher", "LOST", "The Magicans"
        )

        val adapter = ChatAdapter(this, names)
        list.adapter = adapter
    }
}
class ChatAdapter(
    private val context: AppCompatActivity,
    private val names: Array<String>
) : ArrayAdapter<String>(context, R.layout.liner, names) {

    override fun getView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup): android.view.View {
        val inflater = context.layoutInflater
        val rowView = convertView ?: inflater.inflate(R.layout.liner, parent, false)
        val textView = rowView.findViewById<TextView>(R.id.textName)
        textView.text = names[position]
        return rowView
    }
}
