package com.my.views.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.views.R
import com.my.views.adapter.RecyclerViewAdapter
import com.my.views.model.SeriesList

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycler_view)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(
            this,
            1,
            GridLayoutManager.VERTICAL,
            false
        )

        val adapter = RecyclerViewAdapter(SeriesList.getModel())
        recyclerView.adapter = adapter
    }
}