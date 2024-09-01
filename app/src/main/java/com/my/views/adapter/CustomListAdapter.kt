package com.my.views.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.my.views.R

class CustomListAdapter(
    private val context: Activity,
    private val title: Array<String>,
    private val description: Array<String>,
    private val imageId: Array<Int>,
) : ArrayAdapter<String>(context, R.layout.item_list, title) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val view = inflater.inflate(R.layout.item_list, null, true)

        val titleText: TextView = view.findViewById(R.id.tvTitle)
        val descriptionText: TextView = view.findViewById(R.id.tvDescription)
        val imageView: ImageView = view.findViewById(R.id.image)

        titleText.text = title[position]
        descriptionText.text = description[position]
        imageView.setImageResource(imageId[position])

        return view
    }
}