package com.my.views.activities

import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.my.views.R
import com.my.views.adapter.GridAdapter

class GridViewActivity : AppCompatActivity() {

    lateinit var gridView: GridView
    private var numberNames = arrayOf(
        "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten"
    )
    private var numberImages = intArrayOf(
        R.drawable.one_img,
        R.drawable.two_img,
        R.drawable.three_img,
        R.drawable.four_img,
        R.drawable.five_img,
        R.drawable.six_img,
        R.drawable.seven_img,
        R.drawable.eight_img,
        R.drawable.nine_img,
        R.drawable.ten_img,
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_grid_view)

        title = "Grid View"

        gridView = findViewById(R.id.gridView)

        val mainAdapter = GridAdapter(
            context = this,
            numbersInWords = numberNames,
            numberImage = numberImages
        )

        gridView.adapter = mainAdapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                applicationContext, "You CLicked " + numberNames[+position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}