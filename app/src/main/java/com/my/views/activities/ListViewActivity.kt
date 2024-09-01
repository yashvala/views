package com.my.views.activities

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.my.views.R
import com.my.views.adapter.CustomListAdapter

class ListViewActivity : AppCompatActivity() {

    val language = arrayOf("C", "C++", "Java", "Python", "Kotlin", "Android")

    val description = arrayOf(
        "1's Description",
        "2's Description",
        "3's Description",
        "4's Description",
        "5's Description",
        "6's Description",
    )

    val imageId = arrayOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list_view)
        val listView = findViewById<ListView>(R.id.myListView)

        val myListAdapter = CustomListAdapter(this, language, description, imageId)
        listView.adapter = myListAdapter

        /*listView.setOnItemClickListener { adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(
                this,
                "Click on item at $itemAtPos",
                Toast.LENGTH_LONG
            ).show()
        }*/
    }
}